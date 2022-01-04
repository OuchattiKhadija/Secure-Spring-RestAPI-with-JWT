package com.demosecureapi.demosecureapi.config;


import com.demosecureapi.demosecureapi.model.User;
import com.demosecureapi.demosecureapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public CustomUserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User userEntity = userService.getUserByUserName(username);
        return CustomUserDetails.fromUserEntityToCustomUserDetails(userEntity);
    }
}
