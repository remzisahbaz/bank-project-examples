package com.example.validation.user;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UserNameConstraintValidator implements ConstraintValidator<UserNameValidation, String> {


    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return value.isBlank()
                && value.isEmpty()
                && value.length()<3
                && value.length()>10
                && ! value.matches("[0-9a-zA-Z]{3,10}$");
    }
}
