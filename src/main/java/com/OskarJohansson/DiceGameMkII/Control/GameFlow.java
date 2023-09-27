package com.OskarJohansson.DiceGameMkII.Control;

import com.OskarJohansson.DiceGameMkII.Model.Dice;
import com.OskarJohansson.DiceGameMkII.Model.Game;
import com.OskarJohansson.DiceGameMkII.Model.Player;

import java.util.ArrayList;
import java.util.Scanner;

public class GameFlow {

    GameControl gameControl;
    GameTexts texts;
    Game game;
    Dice dice;
    Scanner scanner;

    Player player;
    UserInput userInput;
    boolean isAppRunning;


    public GameFlow() {

        this.gameControl = new GameControl();
        this.texts = new GameTexts();
        this.dice = new Dice();
        this.game = new Game();
        this.scanner = new Scanner(System.in);
        this.player = new Player();
        this.userInput = new UserInput();
        this.isAppRunning = true;
    }

    public void runApp() {

        texts.welcomeMessage();

        texts.numberOfPlayers();
        gameControl.setNumberOfPlayers(game, userInput, scanner);

        gameControl.namePlayers(game, player, texts, scanner);

        texts.numberOfDice();
        gameControl.setNumberOfDies(dice, userInput, scanner);

        texts.numberOfRounds();
        gameControl.setNumberOfRounds(game, userInput, scanner);

        texts.letsStartTheGame();

        int i = 0;

        do {
            texts.getReadyForRound(game.getCounter());
            gameControl.playRound(game, dice, texts, scanner);

            gameControl.showResults(game, texts);

            gameControl.findWinner(game);
            gameControl.findDraw(game);

            while (game.isDraw()) {
                texts.welcomeToDraw();
                gameControl.playDrawRound(game, dice, texts, scanner);
                gameControl.resetDrawInAllObjectsInAllObjects(game);
            }

            if (game.isDraw()) {
                player = game.getDrawWinnerObject();
                texts.theWinnerIs(player.getName(), player.getDrawScore());
                player.setRoundWin();

            } else {
                player = game.getWinnerObject();
                texts.theWinnerIs(player.getName(), player.getScore());
                player.setRoundWin();
            }
            i++;

        } while (isAppRunning || i <= game.getNumberOfRounds());
        texts.playAnotherRound();
        gameControl.playAnotherRound(scanner);
    }
}

