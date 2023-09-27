package com.OskarJohansson.DiceGameMkII.Control;

import com.OskarJohansson.DiceGameMkII.Model.Dice;
import com.OskarJohansson.DiceGameMkII.Model.Game;
import com.OskarJohansson.DiceGameMkII.Model.Player;
import org.jetbrains.annotations.NotNull;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class GameControl {

    int inputReturn = 0;
    boolean appIsRunning = true;


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

    public Player createPlayer(Player player, Scanner scanner) {
        player.setName(scanner.nextLine());
        return player;
    }

    public void namePlayers(Game game,Player player, GameTexts texts, Scanner scanner) {

        ArrayList<Player> playerList = game.getPlayerList();

        for (int i = 0; i < game.getNumberOfPlayers(); i++) {
            texts.enterPlayerName(game.getCounter());
            playerList.add(createPlayer(player, scanner));
            game.addToCounter();
        }
        game.setPlayerList(playerList);
    }

    public void setNumberOfRounds(Game game, @NotNull UserInput userInput, Scanner scanner) {
        String noun = "rounds";
        int maxNumber = 10;

        do this.inputReturn = userInput.maxNumberOfInput(userInput.inputInt(scanner), noun, maxNumber);

        while (this.inputReturn == -1);

        game.setNumberOfRounds(this.inputReturn);
    }

    public void playRound(Game game, Dice dice, GameTexts texts, Scanner scanner) {

        game.getPlayerList().forEach(player -> diceLoop(game, player, dice, texts, scanner));
        dice.resetDiceCounter();

    }

    public void diceLoop(Game game, Player player, Dice dice, GameTexts texts, Scanner scanner) {
        if (game.isDraw()) {
            player.setDrawScore(dice.throwDice());
            texts.diceLoop(player);
            System.out.println(player.getName() + " rolls >>> " + player.getDrawScore());

        } else


            for (int i = 0; i < dice.getNumberOfDice(); i++) {
                System.out.println(player.getName() + " rolls >>> " + player.setDiceRoll(dice.throwDice()) + " <<< with dice >>> " + dice.getDiceCounter() + " <<<");
                player.setScore();
                dice.addToDiceCounter();
                breakButton(scanner);
            }
    }

    public void findWinner(@NotNull Game game) {
        ArrayList<Player> playerList = game.getPlayerList();

        for (Player player : playerList) {

            while (game.isDraw()) {
                if (player.getDrawScore() > game.getDrawWinnerScore()) {
                    game.setDrawWinnerScore(player.getDrawScore());
                    game.setDrawWinnerObject(player);
                }
            }
            if (player.getScore() > game.getWinnerScore()) {
                game.setWinnerScore(player.getScore());
                game.setWinnerObject(player);
            }
        }
    }

    public void showResults(Game game, GameTexts texts) {
        game.getPlayerList().forEach(player -> texts.showResult(player));
    }

    public void playDrawRound(Game game, Dice dice,GameTexts texts, Scanner scanner) {
        ArrayList<Player> playerList = game.getPlayerList();
        if (game.isDraw())
            for (Player player : playerList) {
                if (player.getDraw()) {
                    diceLoop(game, player, dice, texts, scanner);
                }
            }
    }

    public void findDraw(Game game) {

        ArrayList<Player> playerList = game.getPlayerList();

        for (Player player : playerList) {

            while (player.getDraw()) {

                if (player.getDrawScore() == game.getWinnerObject().getDrawScore() && !Objects.equals(player.getName(), game.getWinnerObject().getName())) {
                    player.setDraw(true);
                    game.getWinnerObject().setDraw(true);
                    game.setDraw(true);
                }
            }
            if (player.getScore() == game.getWinnerObject().getScore() && !Objects.equals(player.getName(), game.getWinnerObject().getName())) {
                player.setDraw(true);

                game.getWinnerObject().setDraw(true);
                game.setDraw(true);
            }
        }
    }

    public void resetScoreInAllObjects(Game game) {
        game.getPlayerList().forEach(Player::resetScore) ;
    }

    public void resetDrawWinnerScoreInAllObjects(Game game) {
        game.getPlayerList().forEach(Player:: resetDrawScore);
    }

    public void resetDrawInAllObjectsInAllObjects(Game game) {
        game.getPlayerList().forEach(Player::resetDraw);
    }

    public void resetAll(Game game) {
        resetScoreInAllObjects(game);
        resetDrawWinnerScoreInAllObjects(game);
        resetDrawInAllObjectsInAllObjects(game);
        game.setWinnerScore(0);
        game.resetDrawWinnerObject();
        game.resetWinnerObject();
    }

    public void resetRoundWin(@NotNull ArrayList<Player> playerList) {
        for (Player player : playerList) {
            player.resetRoundWin();
        }
    }

    public void breakButton(@NotNull Scanner scanner) {
        System.out.println("Press 'Enter' to continue");
        scanner.nextLine();
    }

    public void playAnotherRound(@NotNull Scanner scanner) {
        this.appIsRunning = scanner.nextLine().equalsIgnoreCase("y");
    }
}
