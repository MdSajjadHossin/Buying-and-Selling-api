package com.springboot.bikroy.dto;

import com.springboot.bikroy.enums.Role;
import lombok.Data;

@Data
public class UserDto {
    private Long id;
    private String name;
    private String email;
    private String password;
    private String phone;
    private Role role;
}
