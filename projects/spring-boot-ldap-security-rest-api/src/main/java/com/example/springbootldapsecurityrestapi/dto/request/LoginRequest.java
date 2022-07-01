package com.example.springbootldapsecurityrestapi.dto.request;

import com.example.springbootldapsecurityrestapi.validation.password.PasswordValidation;
import com.example.springbootldapsecurityrestapi.validation.user.UserNameValidation;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data

public class LoginRequest {

    @UserNameValidation
    private String userName;
    @PasswordValidation
    private String password;

}
