package com.OskarJohansson.DiceGameMkII;

public class Dice {

    // Sides of the dice
    int sides = 6;

    //Number of dies to throw
    int value = 1;

    UserInput scanner = new UserInput();

    // Get number of dies to use in game
    public int getValue() {
        return value;
    }
    // Set number of dies to use in game

    public int setValue() {
        int input = scanner.inputInt();
        while (input > 10) {
            System.out.println("Maximum number of die are 10! Try Again: ");
            input = scanner.inputInt();
        }
        this.value = input;
        return value;
    }

    public int getSides() {
        return sides;
    }

    public void setSides(int sides) {
        int input = scanner.inputInt();
        while (input > 10) {
            System.out.println("Maximum number of sides are 20! Try Again: ");
            input = scanner.inputInt();
        }
        this.sides = sides;
    }
}
