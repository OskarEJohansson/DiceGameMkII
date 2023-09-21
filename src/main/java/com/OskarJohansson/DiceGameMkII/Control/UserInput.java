package com.OskarJohansson.DiceGameMkII.Control;

import java.util.Scanner;

public class UserInput {

    Scanner sc = new Scanner(System.in);

    public int inputInt() {

        while (!sc.hasNextInt()) {
            System.out.println("That's not a number!");
            sc.next();
        }
        return sc.nextInt();
    }

    public boolean maxNumberOfInput(int input, String noun, int maxNumber) {
            boolean maxNumberReached = false;
        if (input > maxNumber) {
            System.out.println("Maximum number of " + noun + " are " + maxNumber + ". Try Again! ");
            maxNumberReached = true;
        }
        return maxNumberReached;
    }

}
