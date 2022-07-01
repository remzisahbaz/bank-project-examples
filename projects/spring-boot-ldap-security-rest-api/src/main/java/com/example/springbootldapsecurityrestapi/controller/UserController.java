package com.example.springbootldapsecurityrestapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

import java.util.Date;
import java.util.Optional;

@RestController
@RequestScope
@RequestMapping("/")
public class UserController {
    @GetMapping
    public Optional<String> hey(){

        return Optional.of("Giriş başarılı '\\'n Merhaba remzi şuan saat "+ new Date().getHours()+":"+new Date().getMinutes());
    }
}
