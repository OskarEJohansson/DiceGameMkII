package com.OskarJohansson.DiceGameMkII.Control.GameControl;

import com.OskarJohansson.DiceGameMkII.Control.GameTexts;
import com.OskarJohansson.DiceGameMkII.Model.Dice;
import com.OskarJohansson.DiceGameMkII.Model.Game;
import com.OskarJohansson.DiceGameMkII.Model.Player;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Stream;

public class PlayRound {

    boolean appIsRunning = true;

    public boolean playRound(Game game, Dice dice, GameTexts texts, Scanner scanner) {

        Boolean isDraw = false;

        if (game.getPlayerList().stream().filter(Player::getDraw).toArray().length > 0) {
            isDraw = true;
            game.getPlayerList().stream().filter(Player::getDraw).forEach(player -> {
                diceLoop(game, player, dice, texts, scanner);
            });
        } else {
            game.getPlayerList().forEach(player -> diceLoop(game, player, dice, texts, scanner));
            dice.resetDiceCounter();
        }
        return isDraw;
    }

    public void diceLoop(Game game, Player player, Dice dice, GameTexts texts, Scanner scanner) {

        if (player.getDraw()) {
            player.setDrawScore(dice.throwDice());
            texts.diceLoopDraw(player);
            player.setDraw(false);
            breakButton(scanner);
            return;
        }

        for (int i = 0; i < dice.getNumberOfDice(); i++) {

            player.setDiceRoll(dice.throwDice());
            player.setScore();
            texts.diceLoop(player, dice);
            ;
            dice.addToDiceCounter();
            breakButton(scanner);
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
