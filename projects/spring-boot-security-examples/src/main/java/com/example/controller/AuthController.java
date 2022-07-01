package com.example.controller;

import com.example.dto.request.LoginRequest;
import com.example.dto.request.UserRegisterRequest;
import com.example.model.User;
import com.example.security.JwtTokenProvider;
import com.example.service.business.UserServiceImp;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;
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
    @ResponseStatus(code = HttpStatus.OK)
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest){

        var verify=verifyUserName(loginRequest);
        System.out.println(passwordEncoder.encode(loginRequest.getPassword()));
      //  System.out.println(passwordEncoder.(verify.get().getPassword()));

        if(verify.isPresent()) {
        /*    if(verifyPassword(verify.get(),loginRequest).booleanValue()){

        }
            else
                return new ResponseEntity<>("Parolanız Hatalı ! ",
                                             HttpStatus.BAD_REQUEST);*/
            return new ResponseEntity<>("Giriş Başarılı . Token bilginiz: " +
                    createToken(loginRequest),
                    HttpStatus.OK);

        }
        else {
                return new ResponseEntity<>("Kullanıcı adınızı kontrol edidiniz !",
                    HttpStatus.BAD_REQUEST);
        }

    }

    private String createToken(LoginRequest loginRequest){
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken
                        (loginRequest.getUserName(), loginRequest.getPassword());
        Authentication auth = authenticationManager.authenticate(authenticationToken);
        SecurityContextHolder.getContext().setAuthentication(auth);
        String jwtToken = "Bearer" + jwtTokenProvider.generatedJwtToken(auth);
        return jwtToken;
    }

    private Optional<User> verifyUserName(LoginRequest loginRequest) {
        var existUser=userService.getOneUser(loginRequest);
            if( existUser.isPresent()){
                return existUser;
            }
            else
                return Optional.empty();
    }    private Boolean verifyPassword(User existUser,LoginRequest loginRequest) {
            var verify=passwordEncoder.encode(existUser.getPassword()).equals(loginRequest.getPassword());
                if(verify){
                    return Boolean.TRUE;
                }
                else
                    return Boolean.FALSE;
    }

    @PostMapping("/register")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Optional<String> register(@RequestBody UserRegisterRequest userRegisterRequest ){

        Objects.isNull(userRegisterRequest.getUserName());
        Objects.isNull(userRegisterRequest.getPassword());

        // System.out.println(userRegisterRequest);
       return userService.create(userRegisterRequest);
    }
}
