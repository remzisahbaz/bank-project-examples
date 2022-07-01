package com.example.springbootldapsecurityrestapi.service;

import com.example.springbootldapsecurityrestapi.dto.request.LoginRequest;
import com.example.springbootldapsecurityrestapi.dto.request.UserRegisterRequest;
import com.example.springbootldapsecurityrestapi.model.User;

import java.util.Optional;

public interface UserService {

    public Optional<String> create(UserRegisterRequest userRegisterRequest);

    public Optional<Boolean> login(LoginRequest loginRequest);

    public Optional<User> getOneUser(LoginRequest loginRequest);
}
