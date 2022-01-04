package com.demosecureapi.demosecureapi.controller;

import com.demosecureapi.demosecureapi.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AuthResponse {

    private User user ;
    private String token;
}
