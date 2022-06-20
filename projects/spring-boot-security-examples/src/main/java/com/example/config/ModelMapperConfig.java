package com.example.config;

import com.example.dto.request.UserRegisterRequest;
import com.example.model.User;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class ModelMapperConfig {
    private   static PasswordEncoder passwordEncoder;

    public ModelMapperConfig(PasswordEncoder passwordEncoder) {
        ModelMapperConfig.passwordEncoder= passwordEncoder;
    }

    private static final Converter<UserRegisterRequest, User> USER_REGISTER_REQUEST_CONVERTED_TO_USER =
            (context -> {
                var source= context.getSource();
                CharSequence charSequence= source.getPassword();
               System.out.println("*************"+passwordEncoder.encode(charSequence));
                User user= User.builder()
                        .userName(source.getUserName())
                        .password(passwordEncoder.encode(source.getPassword()))
                        .build();
                return user;
            });

    @Bean
    public ModelMapper mapper(){
        ModelMapper map= new ModelMapper();
        map.addConverter(USER_REGISTER_REQUEST_CONVERTED_TO_USER, UserRegisterRequest.class, User.class);
   return map;
    }
}
