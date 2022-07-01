package com.example.dto.response;

import com.example.validation.password.PasswordValidation;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data

public class UserResponse {

    private String userName;
    private String password;
}
