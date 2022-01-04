package com.demosecureapi.demosecureapi.service;

import com.demosecureapi.demosecureapi.model.Role;
import com.demosecureapi.demosecureapi.model.User;
import com.demosecureapi.demosecureapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
@Transactional
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleService roleService;

    @Autowired
    private PasswordEncoder passwordEncoder;

   public List<User> getUsers(){
      return userRepository.findAll();
   }

   public User createUser(User user){
       user.setRole(roleService.findRole("ROLE_USER"));
       user.setPassword(passwordEncoder.encode(user.getPassword()));
       return userRepository.save(user);
   }

   public User getUserByUserName(String userName){
       return userRepository.findUserByUserName(userName);
   }

    public User findByLoginAndPassword(String login, String password) {
        User userEntity = getUserByUserName(login);
        if (userEntity != null) {
            if (passwordEncoder.matches(password, userEntity.getPassword())) {
                return userEntity;
            }
        }
        return null;
    }
}
