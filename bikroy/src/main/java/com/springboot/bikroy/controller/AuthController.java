package com.springboot.bikroy.controller;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.springboot.bikroy.dto.AuthenticationRequest;
import com.springboot.bikroy.dto.SignupRequestDto;
import com.springboot.bikroy.dto.UserDto;
import com.springboot.bikroy.entity.User;
import com.springboot.bikroy.repository.UserRepo;
import com.springboot.bikroy.service.Auth.AuthService;
import com.springboot.bikroy.utils.JwtUtil;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.hibernate.boot.jaxb.Origin;
import org.json.JSONObject;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    private final AuthenticationManager authenticationManager;

    private final UserDetailsService userDetailsService;

    private final JwtUtil jwtUtil;

    private final UserRepo userRepo;

    public static  final String TOKEN_PREFIX = "Bearer";

    public static final String HEDAER_STRING = "Authorization";


    @PostMapping("/clint/signup")
    public ResponseEntity<?> signUpClint(@RequestBody SignupRequestDto signupRequestDto){
        if(authService.presentByEmail(signupRequestDto.getEmail())){
            return new ResponseEntity<>("Client already exist with email", HttpStatus.NOT_ACCEPTABLE);
        }
        UserDto createUser = authService.signupClint(signupRequestDto);
        return new ResponseEntity<>(createUser, HttpStatus.OK);
    }

    @PostMapping("/seller/signup")
    public ResponseEntity<?> signUpSeller(@RequestBody SignupRequestDto signupRequestDto){
        if(authService.presentByEmail(signupRequestDto.getEmail())){
            return new ResponseEntity<>("Seller already exist with email", HttpStatus.NOT_ACCEPTABLE);
        }
        UserDto createUser = authService.signupSeller(signupRequestDto);
        return new ResponseEntity<>(createUser, HttpStatus.OK);
    }

    @PostMapping("/{authenticate}")
    public void createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest, HttpServletResponse response) throws IOException {

        try{
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    authenticationRequest.getUserName(),
                    authenticationRequest.getPassword()
            ));
        }catch (BadCredentialsException ex){
            throw new BadCredentialsException("Incorrect username or password", ex);
        }

        final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUserName());
        final String jwt = jwtUtil.generateToken(userDetails.getUsername());

        User user = userRepo.findFirstByEmail(authenticationRequest.getUserName());

        response.getWriter().write(new JSONObject()
                .put("userId", user.getId())
                .put("role", user.getRole())
                .toString()
        );

        response.addHeader("Access-Control-Expose-Headers", "Authorization");
        response.addHeader("Access-Control-Allow-Headers", "Authorization" +
                "X-PINGOTHER, Origin, X-Request-with, Content-Type, Accept, X-Custom-header");
        response.addHeader(HEDAER_STRING, TOKEN_PREFIX + jwt);


    }
}
