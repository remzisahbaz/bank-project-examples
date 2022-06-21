package com.example.test.password;

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

public class PasswordTest {

    private LoginRequest loginRequest;

    @Mock
    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp(){
        loginRequest= new LoginRequest();
    }


    /**
     *
     * PASSWORD TESTS
     *
     * */
    @ParameterizedTest
    @CsvSource({"Password1@@199++",
            "***Password1@@199++",
            "8975Password)(*-199++",
            "---)Password1@@199++"})
    @DisplayName("Login Password Succesfully")
    void LoginPasswordShouldSuccess(String password){
        loginRequest.setPassword(password);
        Pattern patternUserName= Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>])+.{8,24}$");
        Matcher matcherUserName=patternUserName.matcher(loginRequest.getPassword());

        assertTrue(matcherUserName.matches());
    }

    @ParameterizedTest
    @CsvSource({"fjdgfjdg",
            "***op",
            "AKKPKPLLĞK",
            "12345678",
            "9az.A99999"})
    @DisplayName("Login Password Failled")
    void LoginPasswordShouldFailled(String password){
        loginRequest.setPassword(password);
        Pattern patternUserName= Pattern.compile("^(?=.*[0-9])+(?=.*[a-z])+(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>])+.{8,24}$");
        Matcher matcherUserName=patternUserName.matcher(loginRequest.getPassword());

        assertFalse(matcherUserName.matches());
    }


}
