package com.OskarJohansson.DiceGameMkII.Control.GameControl;

import com.OskarJohansson.DiceGameMkII.Control.UserInput;
import com.OskarJohansson.DiceGameMkII.Model.Dice;
import com.OskarJohansson.DiceGameMkII.Model.Game;
import org.jetbrains.annotations.NotNull;

import java.util.Scanner;
public class SetGameParameters {

    int inputReturn = 0;

    public void setNumberOfPlayers(Game game, UserInput userInput, Scanner scanner) {
        int maxNumber = 10;
        String noun = "players";

        do this.inputReturn = userInput.maxNumberOfInput(userInput.inputInt(scanner), noun, maxNumber);
        while (this.inputReturn == -1);

        game.setNumberOfPlayers(this.inputReturn);
    }

    public void setNumberOfDies(Dice dice, UserInput userInput, Scanner scanner) {
        int maxNumber = 10;
        String noun = "dies";

        do this.inputReturn = userInput.maxNumberOfInput(userInput.inputInt(scanner), noun, maxNumber);

        while (this.inputReturn == -1);

        dice.setNumberOfDice(this.inputReturn);
    }

    public void setNumberDieSides(Dice dice, UserInput userInput, Scanner scanner){
        int maxNumber = 20;
        String noun = "sides";

        do this.inputReturn = userInput.maxNumberOfInput(userInput.inputInt(scanner), noun, maxNumber);

        while (this.inputReturn == -1);

        dice.setNumberOfSides(this.inputReturn);
    }

    public void setNumberOfRounds(Game game, @NotNull UserInput userInput, Scanner scanner) {
        String noun = "rounds";
        int maxNumber = 10;

        do this.inputReturn = userInput.maxNumberOfInput(userInput.inputInt(scanner), noun, maxNumber);

        while (this.inputReturn == -1);

        game.setNumberOfRounds(this.inputReturn);
    }

    public boolean playAnotherRound(Scanner scanner, Boolean appIsRunning) {
        if (scanner.nextLine().equalsIgnoreCase("y")) {
            return appIsRunning = true;
        }else return false;
    }

}