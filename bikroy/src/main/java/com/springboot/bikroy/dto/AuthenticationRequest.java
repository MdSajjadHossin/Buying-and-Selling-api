package com.springboot.bikroy.dto;

import lombok.Data;

@Data
public class AuthenticationRequest {

    private String userName;
    private String password;
}
