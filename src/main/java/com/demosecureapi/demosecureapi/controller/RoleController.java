package com.demosecureapi.demosecureapi.controller;

import com.demosecureapi.demosecureapi.model.Role;
import com.demosecureapi.demosecureapi.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/role/cr")
public class RoleController {

    @Autowired
    RoleService roleService;

    @GetMapping
    public List<Role> getRoles(){
        return roleService.findAll();
    }

    @PostMapping
    public Role createRole(@RequestBody Role role){
        return roleService.createRole(role);
    }
}
