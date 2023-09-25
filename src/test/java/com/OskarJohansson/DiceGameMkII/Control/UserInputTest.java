package com.OskarJohansson.DiceGameMkII.Control;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Before;

public class UserInputTest extends TestCase {

    UserInput userInput;
    @Before

    public void setUp(){
        userInput = new UserInput();
    }

    public void testCheckInputForValidInputs() {

        int result = userInput.inputMustBeAPositiveNumber(1);
        Assert.assertEquals(1, result);

    }
    public void testCheckInputForInvalidInputsEmptyString() {

        int result = userInput.checkInputForInvalidInputs(" \n ");
        Assert.assertEquals(-1, result);
    }

    public void testCheckInputForInvalidInputsNotANumber() {

        int result = userInput.checkInputForInvalidInputs(" ASD123");
        Assert.assertEquals(-1, result);
    }

    public void testCheckInputForInvalidInputIsANegativeNumber() {

        int result = userInput.checkInputForInvalidInputs("-2");
        Assert.assertEquals(-1, result);
    }

    public void testInputMustBeAPositiveNumberPositiveInput() {
        int result = userInput.inputMustBeAPositiveNumber(1);
        Assert.assertEquals(1, result);
    }
    public void testInputMustBeAPositiveNumberNegativeInput() {
        int result = userInput.inputMustBeAPositiveNumber(-10);
        Assert.assertEquals(-1, result);
    }
}