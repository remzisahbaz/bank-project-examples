package com.example.service;

import com.example.dto.request.LoginRequest;
import com.example.dto.request.UserRegisterRequest;

import java.util.Optional;

public interface UserService {

   public Optional<String> create(UserRegisterRequest userRegisterRequest);
   public Optional<String> login(LoginRequest loginRequest);
}
