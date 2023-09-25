package com.OskarJohansson.DiceGameMkII.Control;

import java.util.Scanner;

public class UserInput {

    public int inputInt(Scanner scanner) {
        boolean invalidInput = true;
        int result = 0;

        while (invalidInput) {
            result = checkInputForInvalidInputs(scanner.nextLine());

            if (result != -1) {
                invalidInput = false;
            }
        }
        return result;
    }

    public int checkInputForInvalidInputs(String inputValue) {
        int intValue = 0;

        if (inputValue.isBlank()) {
            System.out.println("Input is empty! Try Again!");
            return -1;

        } else {
            try {
                intValue = inputMustBeAPositiveNumber(Integer.parseInt(inputValue));

            } catch (NumberFormatException e) {
                System.out.println("That's not a number! Try Again!");
                return -1;
            }
        }
        return intValue;
    }

    public int inputMustBeAPositiveNumber(int intValue) {

        if (intValue < 0) {
            System.out.println("Input must be a positive number! Try Again!");
            return -1;
        }
        return intValue;
    }

    public int inputToMaxNumberOfInputs(UserInput userInput, Scanner scanner, String noun, int maxNumber){
        int result;
        result = userInput.maxNumberOfInput(userInput.inputInt(scanner), noun, maxNumber);
        return result;
    }

    public int maxNumberOfInput(int input, String noun, int maxNumber) {
        if (input > maxNumber) {
            System.out.println("Maximum number of " + noun + " are " + maxNumber + ". Try Again! ");
            return -1;
        }
        return input;
    }
}


