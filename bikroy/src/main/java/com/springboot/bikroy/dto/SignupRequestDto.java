package com.springboot.bikroy.dto;

import com.springboot.bikroy.enums.Role;
import lombok.Data;

@Data
public class SignupRequestDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String phone;
}
