package com.example.validation.password;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.lang.annotation.Annotation;

public class PasswordConstraintValidator implements ConstraintValidator<PasswordValidation , String> {



    @Override
    public boolean isValid(
            String value,  ConstraintValidatorContext context) {
       return     value ==null
               && ! value.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>])+.{8,24}$")
               && (value.length() < 8)
               && (value.length()>24);


    }
}
