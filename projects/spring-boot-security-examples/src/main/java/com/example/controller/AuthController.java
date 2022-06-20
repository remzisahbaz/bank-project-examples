package com.example.controller;

import com.example.dto.request.LoginRequest;
import com.example.dto.request.UserRegisterRequest;
import com.example.security.JwtTokenProvider;
import com.example.service.business.UserServiceImp;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/auth")

public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider jwtTokenProvider;
    private final UserServiceImp userService;

    private  PasswordEncoder passwordEncoder;

    public AuthController(AuthenticationManager authenticationManager, JwtTokenProvider jwtTokenProvider, UserServiceImp userService, PasswordEncoder passwordEncoder) {
        this.authenticationManager = authenticationManager;
        this.jwtTokenProvider = jwtTokenProvider;
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping
    public String home(){
        return "Hoşgeldiniz ! Giriş yapmak için tıklayınız ...";
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest loginRequest){

        CharSequence charSequence= loginRequest.getPassword();
        System.out.println("*************"+passwordEncoder.encode(charSequence));

        UsernamePasswordAuthenticationToken authenticationToken=
                new UsernamePasswordAuthenticationToken
                        (loginRequest.getUserName(),loginRequest.getPassword());
        Authentication auth=authenticationManager.authenticate(authenticationToken);
        SecurityContextHolder.getContext().setAuthentication(auth);
        String jwtToken ="Bearer"+ jwtTokenProvider.generatedJwtToken(auth);

        return "Giriş Başarılı . Token bilginiz: "+jwtToken;
    }
    @PostMapping("/register")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Optional<String> register(@RequestBody UserRegisterRequest userRegisterRequest ){

       /* Objects.nonNull(userRegisterRequest.getUserName());
        Objects.nonNull(userRegisterRequest.getPassword());*/

        // System.out.println(userRegisterRequest);
       return userService.create(userRegisterRequest);
    }
}
