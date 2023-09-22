package com.OskarJohansson.DiceGameMkII.Control;

import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

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
        String fakeInput = "";
        scanner = new Scanner(fakeInput);
    }
    @After
    public void tearDown() {
        // Restore the original standard output
        System.setOut(originalOut);

        // Close the fake scanner
        scanner.close();
    }

    @Test
    public void testInputIntValidInput() {

        String fakeInput = "42\n";
        System.setIn(new ByteArrayInputStream(fakeInput.getBytes()));

        String userInput = scanner.nextLine();

        assertEquals(42, userInput);

        assertEquals("", outContent.toString());

    }

    @Test
    public void testInputIntNonIntegerInput() {

        String fakeInput = "NotANumber\n"; // This is not a valid integer input
        System.setIn(new ByteArrayInputStream(fakeInput.getBytes()));

        // Use the fake scanner as input source
        scanner.next(fakeInput);

        // Call the inputInt method
        int result = userInput.inputInt();

        // Assert that the result is the default value (0 in this case)
        assertEquals(0, result);
        // Assert that the error message is printed
        assertTrue(outContent.toString().contains("That's not a number!"));
    }

}
