package com.springboot.bikroy.service.Auth;

import com.springboot.bikroy.dto.SignupRequestDto;
import com.springboot.bikroy.dto.UserDto;

public interface AuthService{
    UserDto signupClint(SignupRequestDto signupRequestDto);

    UserDto signupSeller(SignupRequestDto signupRequestDto);
    Boolean presentByEmail(String email);
}
