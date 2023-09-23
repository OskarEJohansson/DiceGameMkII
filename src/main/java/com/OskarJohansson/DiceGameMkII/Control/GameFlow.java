package com.OskarJohansson.DiceGameMkII.Control;

import com.OskarJohansson.DiceGameMkII.Model.Dice;
import com.OskarJohansson.DiceGameMkII.Model.Player;

import java.util.ArrayList;
import java.util.Scanner;

public class GameFlow {

    GameControl gameControl;
    GameTexts texts;
    Dice dice;
    Scanner scanner;
    ArrayList<Player> playerList;
    Player player;
    UserInput userInput;
    boolean isAppRunning;


    public GameFlow() {

        this.gameControl = new GameControl();
        this.texts = new GameTexts();
        this.dice = new Dice();
        this.scanner = new Scanner(System.in);
        this.playerList = new ArrayList<>();
        this.player = new Player();
        this.userInput = new UserInput();
        this.isAppRunning = true;
    }

    public void runApp() {

        texts.welcomeMessage();

        texts.numberOfPlayers();
        gameControl.setNumberOfPlayers(scanner, userInput);

        this.playerList = gameControl.namePlayers(playerList, scanner, texts);

        texts.numberOfDice();
        gameControl.setNumberOfDies(dice, userInput, scanner);

        texts.numberOfRounds();
        gameControl.setNumberOfRounds(scanner, userInput);

        texts.letsStartTheGame();

        // OBS i = 1 and <= in forloop!
        while (isAppRunning) {
            for (int i = 1; i <= gameControl.numberOfRounds; i++) {

                gameControl.resetAll(playerList);

                texts.getReadyForRound(i);
                gameControl.playRound(playerList, player, dice, scanner);

                texts.showResult();
                gameControl.showResults(playerList);

                gameControl.findWinner(playerList);
                gameControl.findDraw(playerList);

                while (gameControl.isDraw) {
                    texts.welcomeToDraw();
                    gameControl.playDrawRound(dice, playerList, scanner);
                    gameControl.resetDrawInAllObjectsInAllObjects(playerList);
                }

                if (gameControl.isDraw) {
                    texts.theWinnerIs(gameControl.drawWinnerObject.getName(), gameControl.drawWinnerObject.getDrawScore());
                    gameControl.drawWinnerObject.setRoundWin();

                } else {

                    texts.theWinnerIs(gameControl.winnerObject.getName(), gameControl.winnerObject.getScore());
                    gameControl.winnerObject.setRoundWin();
                }
            }
            texts.playAnotherRound();
            gameControl.playAnotherRound(scanner);
        }
    }
}
