package com.example.junitinjava;

import com.example.junitinjava.basicExamples.StringOperation;
import org.apache.logging.log4j.util.Strings;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class StringOperationTest {

    StringOperation testInstance ;

    @BeforeEach
    void setUp() {
        testInstance = new StringOperation();
    }


    @Test
    public void tetsFirstTwoCharacters_StringOne() {

        String input = "a";
        String expect = "a";
        String actual = testInstance.firstTwoCharacters(input);
        assertEquals(expect, actual);

    }

    @Test
    public void testFirstTwoCharacters() {

        assertEquals("sa", testInstance.firstTwoCharacters("salata"));
    }

    @ParameterizedTest
//  @CsvFileSource(resources = "inputs.csv")
    @CsvSource({"salata", "armut"})
    @DisplayName("successfuly")
    void onlyInputStringCharactersShouldSuccess(String inputString) {
        Pattern pattern = Pattern.compile("[a-z]+"); //only string characters
        Matcher matcher = pattern.matcher(inputString);

        // verification
        assertEquals(true, matcher.matches());

    }

    @ParameterizedTest
    @ValueSource(strings = {"31", "33", "35", "10", "15"}) // six numbers
    @DisplayName("fail")
    void onlyInputStringCharactersShouldFail(String inputString) {
        Pattern pattern = Pattern.compile("[0-9]"); //only string characters
        Matcher matcher = pattern.matcher(inputString);

        // verification
        assertFalse(matcher.matches());

    }

    @ParameterizedTest
    @NullSource
    @DisplayName("Null-Source")
    void anyInputStringCharacters(String inputString) {

        assertTrue(Strings.isBlank(inputString));
    }



}
