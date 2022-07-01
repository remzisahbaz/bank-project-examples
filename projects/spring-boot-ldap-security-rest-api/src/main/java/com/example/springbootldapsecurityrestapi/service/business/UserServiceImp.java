package com.example.springbootldapsecurityrestapi.service.business;


import com.example.springbootldapsecurityrestapi.dto.request.LoginRequest;
import com.example.springbootldapsecurityrestapi.dto.request.UserRegisterRequest;
import com.example.springbootldapsecurityrestapi.model.User;
import com.example.springbootldapsecurityrestapi.repository.UserRepository;
import com.example.springbootldapsecurityrestapi.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class UserServiceImp implements UserService {

    private UserRepository userRepository;
    private ModelMapper modelMapper;


    public UserServiceImp(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public Optional<String> create(UserRegisterRequest request) {
        var exist = userRepository.findByUserName(request.getUserName());
        if (exist == null) {
            var newUser = userRepository.save(modelMapper.map(request, User.class));

            if (newUser != null)
                return Optional.ofNullable(Optional.ofNullable("Kayıt Başarılı, yeni kullanıcı :" + newUser.getUserName()).orElseThrow(IllegalArgumentException::new));
        } else {
            return Optional.of("Bu kullanıcı adı daha önce kullanılmıştır.");
        }

        return Optional.empty();
    }

    @Override
    public Optional<Boolean> login(LoginRequest loginRequest) {
        var exist = userRepository.findByUserName(loginRequest.getUserName());

        if (exist != null) {
            if (loginRequest.getPassword().equals(exist.getPassword())) {
                return Optional.of(Boolean.TRUE);
            } else {
                return Optional.of(Boolean.FALSE);
            }
        }

        return Optional.empty();
    }

    @Override
    public Optional<User> getOneUser(LoginRequest loginRequest) {
        var user = userRepository.findByUserName(loginRequest.getUserName());
        if (user != null) {
            return Optional.ofNullable(Optional.ofNullable(user).orElseThrow(IllegalArgumentException::new));
        }

        return Optional.empty();
    }


}
