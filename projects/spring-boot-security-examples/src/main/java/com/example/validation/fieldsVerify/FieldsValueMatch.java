package com.example.validation.fieldsVerify;

import javax.validation.Constraint;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = FieldsConstraintValidator.class)
public @interface FieldsValueMatch {

    public String message()default "Please,fields must be equal";
    public String field();
    public String fieldMatch();

    @Target({ElementType.TYPE, ElementType.FIELD})
    @Retention(RetentionPolicy.RUNTIME)
    @interface List{
        FieldsValueMatch[] value();
    }


}
