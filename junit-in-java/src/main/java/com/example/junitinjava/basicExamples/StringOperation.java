package com.example.junitinjava.basicExamples;

public class StringOperation {

    public String firstTwoCharacters(String input) {
        if (input.length() <= 2) {
            return input;
        } else {
            String twoChar = input.substring(0, 2);
            return twoChar;
        }

    }
    public String blankString (String input){

        return input;
    }
}
