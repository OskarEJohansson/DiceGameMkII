package com.OskarJohansson.DiceGameMkII.Control;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

import java.util.Scanner;

public class MaxNumberOfInputTest extends TestCase {

    private UserInput userInput;
    private Scanner scanner;

    @Before
    public void setUp(){
        userInput = new UserInput();
        scanner = new Scanner(System.in);
    }
    @Test
    public void testMaxNumberOfInputExceeded() {
        int input = 15;
        String noun = "bapples";
        int maxNumber = 10;

        assertTrue(userInput.maxNumberOfInput(input, noun, maxNumber));
    }

    @Test
    public void testMaxNumberOfInputNotExceeded(){
        int input = 5;
        String noun = "apples";
        int maxNumber= 10;

        assertFalse(userInput.maxNumberOfInput(input,noun,maxNumber));
    }
}