package com.OskarJohansson.DiceGameMkII.Model;

import com.OskarJohansson.DiceGameMkII.Control.GameTexts;
import com.OskarJohansson.DiceGameMkII.Control.UserInput;

import java.util.Random;

public class Dice {

    //Number of dies to throw
    int diceCounter = 1;
    Random randomizer = new Random();


    //Get diceCount in game
    public int getDiceCounter() {
        return diceCounter;
    }

    // Set DiceCounter in game
    public void addToDiceCounter() {
        this.diceCounter++;
    }

    public void resetDiceCounter(){
        this.diceCounter = 1;
    }

    public int throwDice(){
        return randomizer.nextInt(1, 7);
    }
}
