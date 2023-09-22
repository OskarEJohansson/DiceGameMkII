package com.OskarJohansson.DiceGameMkII.Control;

import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class inputIntTest {

    private UserInput userInput;
    private ByteArrayOutputStream outContent;
    private PrintStream originalOut;
    private Scanner scanner;

    @Before
    public void setUp(){
        userInput = new UserInput();

        outContent = new ByteArrayOutputStream();
        originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        scanner = new Scanner(System.in);
    }
    @After
    public void tearDown() {
        // Restore the original standard output
        System.setOut(originalOut);

        // Close the fake scanner
        scanner.close();
    }

    @Test
    public void testInputIntValidInput(){

        String fakeInput = "42\n";
    }

}
