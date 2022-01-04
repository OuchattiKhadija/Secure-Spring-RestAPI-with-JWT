package com.demosecureapi.demosecureapi.controller;

import lombok.Data;

@Data
public class AuthRequest {
    private String userName;
    private String password;
}
