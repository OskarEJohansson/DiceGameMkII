package com.OskarJohansson.DiceGameMkII.Control;

import java.util.Scanner;

public class UserInput {

    Scanner sc = new Scanner(System.in);


    public int inputInt(Scanner scanner) {
        while (true) {
            String inputValue = scanner.nextLine();

            if (inputValue.isEmpty()) {
                System.out.println("Input is empty!");
            } else {
                try {
                    int intValue = Integer.parseInt(inputValue);
                    if (intValue < 0) {
                        System.out.println("Input must be a positive number!");
                    } else return intValue;

                } catch (NumberFormatException e) {
                    System.out.println("That's not a number!");
                }
            }
        }
    }

    public boolean maxNumberOfInput(int input, String noun, int maxNumber) {
        boolean maxNumberReached = false;
        try {
            if (input > maxNumber) {
                throw new IllegalArgumentException("Maximum number of " + noun + " are " + maxNumber + ". Try Again! ");
            } else if (input < 0) {
                System.out.println("Input must be a positive number!");
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            maxNumberReached = true;
        }

        return maxNumberReached;
    }
}
