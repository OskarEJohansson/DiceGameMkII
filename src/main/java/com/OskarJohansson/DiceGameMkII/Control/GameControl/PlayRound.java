package com.OskarJohansson.DiceGameMkII.Control.GameControl;

import com.OskarJohansson.DiceGameMkII.Control.GameTexts;
import com.OskarJohansson.DiceGameMkII.Model.Dice;
import com.OskarJohansson.DiceGameMkII.Model.Draw;
import com.OskarJohansson.DiceGameMkII.Model.Game;
import com.OskarJohansson.DiceGameMkII.Model.Player;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Stream;

public class PlayRound {

    public void playRound(Game game, Dice dice, GameTexts texts, Draw draw, Scanner scanner) {
        game.getPlayerList().forEach(player ->
                diceLoop(player, dice, texts));

        System.out.println("Press 'Enter' to continue");
        scanner.nextLine();
    }

    public void diceLoop(Player player, Dice dice, GameTexts texts) {

        dice.resetDiceCounter();

        for (int i = 0; i < dice.getNumberOfDice(); i++) {
            player.setDiceRoll(dice.throwDice());
            player.setScore();
            texts.diceLoop(player, dice);
            dice.addToDiceCounter();
        }
    }

    public void playDrawRound(Dice dice, GameTexts texts, Draw draw, Scanner scanner) {
        draw.getDrawPlayerList().forEach(player -> {
            dice.resetDiceCounter();
            diceLoopDraw(player, dice, texts);

            System.out.println("Press 'Enter' to continue");
            scanner.nextLine();
        });
    }

    public void diceLoopDraw(Player player, Dice dice, GameTexts texts) {
        dice.resetDiceCounter();
        player.setDrawScore(dice.throwDice());
        texts.diceLoopDraw(player);

    }
}
