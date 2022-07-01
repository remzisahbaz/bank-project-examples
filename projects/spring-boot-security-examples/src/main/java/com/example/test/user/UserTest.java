package com.example.test.user;

import com.example.dto.request.LoginRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mock;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserTest {

    private LoginRequest loginRequest;

    @Mock
    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp(){
        loginRequest= new LoginRequest();
    }

    /**
     *
     * USERNAME TESTS
     *
     * */
    @ParameterizedTest
    @CsvSource({"sdf",
            "zaza789",
            "8975usernamee",
            "ATARCA874"})
    @DisplayName("Login Username Succesfully")
    void LoginUserNameShouldSuccess(String userName){
        loginRequest.setUserName(userName);
        Pattern patternUserName= Pattern.compile("[0-9a-zA-Z]{3,10}$");
        Matcher matcherUserName=patternUserName.matcher(loginRequest.getUserName());

        assertTrue(matcherUserName.matches());
    }
    @ParameterizedTest
    @CsvSource({"----",
                "mmklkjhtyyyygsagdsfsfddsfasdsaf",
            "-147",
            "*//8",
            "Ü_ATARCA874",
            "ökküş"})
    @DisplayName("Login Username Failled")
    void LoginUserNameShouldFailled(String userName){
        loginRequest.setUserName(userName);
        Pattern patternUserName= Pattern.compile("[0-9a-zA-Z]{3,10}$");
        Matcher matcherUserName=patternUserName.matcher(loginRequest.getUserName());

        assertFalse(matcherUserName.matches());
    }



}
