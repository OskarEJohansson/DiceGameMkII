package com.OskarJohansson.DiceGameMkII.Control;

import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.junit.Assert.*;

public class inputIntTest {

    @Test
    public void testInputIntValidInput() {

        String fakeInput = "10";
        System.setIn(new ByteArrayInputStream(fakeInput.getBytes()));

        Scanner scanner = new Scanner(System.in);
        int userInput = scanner.nextInt();

        assertEquals(10, userInput);
        assertNotEquals(30, userInput);
        scanner.close();
    }
}
