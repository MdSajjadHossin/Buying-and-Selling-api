package com.springboot.bikroy.service.Auth;

import com.springboot.bikroy.dto.SignupRequestDto;
import com.springboot.bikroy.dto.UserDto;
import com.springboot.bikroy.entity.User;
import com.springboot.bikroy.enums.Role;
import com.springboot.bikroy.repository.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService{

    private final UserRepo userRepo;

    public UserDto signupClint(SignupRequestDto signupRequestDto){
        User user = new User();

        user.setFirstName(signupRequestDto.getFirstName());
        user.setLastName(signupRequestDto.getLastName());
        user.setEmail(signupRequestDto.getEmail());
        user.setPassword(new BCryptPasswordEncoder().encode(signupRequestDto.getPassword()));
        user.setPhone(signupRequestDto.getPhone());
        user.setRole(Role.BUYER);



        return userRepo.save(user).getDto();
    }

    public Boolean presentByEmail(String email){
        return userRepo.findFirstByEmail(email) != null;
    }

    public UserDto signupSeller(SignupRequestDto signupRequestDto){
        User user = new User();

        user.setFirstName(signupRequestDto.getFirstName());
        user.setLastName(signupRequestDto.getLastName());
        user.setEmail(signupRequestDto.getEmail());
        user.setPassword(new BCryptPasswordEncoder().encode(signupRequestDto.getPassword()));
        user.setPhone(signupRequestDto.getPhone());
        user.setRole(Role.SELLER);

        return userRepo.save(user).getDto();
    }

}
