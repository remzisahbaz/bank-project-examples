package com.example.service;

import com.example.dto.request.LoginRequest;
import com.example.dto.request.UserRegisterRequest;
import com.example.model.User;

import java.util.Optional;

public interface UserService {

   public Optional<String> create(UserRegisterRequest userRegisterRequest);
   public Optional<Boolean> login(LoginRequest loginRequest);
   public Optional<User> getOneUser(LoginRequest loginRequest);
}
