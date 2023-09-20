package com.OskarJohansson.DiceGameMkII;

public class Dice {

    // Sides of the dice
    int sides = 6;

    //Number of dies to throw
    int value = 1;

    // Get number of dies to use in game
    public int getValue() {
        return value;
    }

    // Set number of dies to use in game
    public void setValue(int value) {
        System.out.println("Set number of dies to use in game: ");
        this.value = value;
    }
}
