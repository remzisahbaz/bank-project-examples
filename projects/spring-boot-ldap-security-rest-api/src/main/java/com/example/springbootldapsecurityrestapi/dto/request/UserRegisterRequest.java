package com.example.springbootldapsecurityrestapi.dto.request;

import com.example.springbootldapsecurityrestapi.validation.fieldsVerify.FieldsValueMatch;
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
@FieldsValueMatch.List(
        {
                @FieldsValueMatch
                (
                field = "password",
                fieldMatch = "verifyPassword",
                message = "Passwords do not match !"

                )
           /*     ,  @FieldsValueMatch
                (
                        field = "email",
                        fieldMatch = "verifyEmail",
                        message = "Passwords do not match !"

                )*/
        }
)
public class UserRegisterRequest {
    @UserNameValidation
    private String userName;
    @PasswordValidation
    private String password;
    @PasswordValidation
    private String verifyPassword;

}
