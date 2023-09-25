package com.OskarJohansson.DiceGameMkII.Control;

import junit.framework.TestCase;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.junit.Assert.*;

public class inputIntTest {

    private UserInput userInput;

    @Before
    public void setUp() {
        userInput = new UserInput();

    }

    @Test
    public void testInputIntValidInput() {

        String fakeInput = "10\n";
        System.setIn(new ByteArrayInputStream(fakeInput.getBytes()));

        Scanner scanner = new Scanner(System.in);

        int result = userInput.inputInt(scanner);

        Assert.assertEquals(10, result);

    }
}

