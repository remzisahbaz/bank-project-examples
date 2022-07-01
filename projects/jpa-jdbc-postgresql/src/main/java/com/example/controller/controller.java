package com.example.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

import javax.annotation.PostConstruct;

@RestController
@RequestScope
@RequestMapping("/")
public class controller {

    @PostConstruct
    public String index(){

        return "1Mderhaba";

    }
}
