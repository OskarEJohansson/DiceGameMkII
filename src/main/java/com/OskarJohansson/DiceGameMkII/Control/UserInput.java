package com.OskarJohansson.DiceGameMkII.Control;

import java.util.Scanner;

public class UserInput {

    Scanner sc = new Scanner(System.in);


    public int inputInt() {
        while (true) {
            String userInput = sc.next();
            try {
                int intValue = Integer.parseInt(userInput);
                return intValue;
            } catch (NumberFormatException e) {
                System.out.println("That's not a number!");
            }
        }
    }

    public boolean maxNumberOfInput(int input, String noun, int maxNumber) {
        boolean maxNumberReached = false;
        try {
            if (input > maxNumber) {
                throw new IllegalArgumentException("Maximum number of " + noun + " are " + maxNumber + ". Try Again! ");

            }
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            maxNumberReached = true;
        }

        return maxNumberReached;
    }
}
