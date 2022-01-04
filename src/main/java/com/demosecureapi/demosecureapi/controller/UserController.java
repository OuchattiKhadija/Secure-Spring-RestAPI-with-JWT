package com.demosecureapi.demosecureapi.controller;


import com.demosecureapi.demosecureapi.config.jwt.JwtProvider;
import com.demosecureapi.demosecureapi.model.User;
import com.demosecureapi.demosecureapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users/")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    JwtProvider jwtProvider;

    @PostMapping("register")
    public ResponseEntity<User> createUser(@RequestBody User user){
        User user1 = userService.createUser(user);
        if (user1 == null){
            return new ResponseEntity<>(user1,HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(user1, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<User>> getUser(){
        List<User> user1 = userService.getUsers();
        if (user1 == null){
            return new ResponseEntity<>(user1,HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(user1, HttpStatus.OK);
    }

    @PostMapping("auth")
    public AuthResponse auth(@RequestBody AuthRequest request) {
        User userEntity = userService.findByLoginAndPassword(request.getUserName(), request.getPassword());
        String token = jwtProvider.generateToken(userEntity.getUserName());
        return new AuthResponse(userEntity,token);
    }
}
