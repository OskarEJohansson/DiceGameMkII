package com.OskarJohansson.DiceGameMkII.Control.GameControl;

import com.OskarJohansson.DiceGameMkII.Control.GameTexts;
import com.OskarJohansson.DiceGameMkII.Model.Dice;
import com.OskarJohansson.DiceGameMkII.Model.Game;
import com.OskarJohansson.DiceGameMkII.Model.Player;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Scanner;

public class PlayRound {

    boolean appIsRunning = true;

    public void playRound(Game game, Dice dice, GameTexts texts, Scanner scanner) {

        game.getPlayerList().forEach(player -> diceLoop(game, player, dice, texts, scanner));
        dice.resetDiceCounter();
    }

    public void diceLoop(Game game, Player player, Dice dice, GameTexts texts, Scanner scanner) {

        if (game.isDraw()) {
            player.setDrawScore(dice.throwDice());
            texts.diceLoopDraw(player);

        } else

            for (int i = 0; i < dice.getNumberOfDice(); i++) {

                player.setDiceRoll(dice.throwDice());
                player.setScore();
                texts.diceLoop(player, dice);;
                dice.addToDiceCounter();
                breakButton(scanner);
            }
    }
    public void playDrawRound(Game game, Dice dice, GameTexts texts, Scanner scanner) {

        if (game.isDraw()) {

            for (Player player : game.getPlayerList()) {

                if (player.getDraw()) {
                    diceLoop(game, player, dice, texts, scanner);
                }
            }
        }
    }
    public void playAnotherRound(Scanner scanner) {
        this.appIsRunning = scanner.nextLine().equalsIgnoreCase("y");
    }

    public void breakButton(@NotNull Scanner scanner) {
        System.out.println("Press 'Enter' to continue");
        scanner.nextLine();
    }
}
