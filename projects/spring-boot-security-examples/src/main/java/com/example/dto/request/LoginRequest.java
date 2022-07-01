package com.example.dto.request;

import com.example.validation.password.PasswordValidation;
import com.example.validation.user.UserNameValidation;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;


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
