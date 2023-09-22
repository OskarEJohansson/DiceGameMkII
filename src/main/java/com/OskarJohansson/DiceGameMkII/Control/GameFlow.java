package com.OskarJohansson.DiceGameMkII.Control;

import com.OskarJohansson.DiceGameMkII.Model.Dice;

import java.util.Scanner;

public class GameFlow {

    GameTexts texts = new GameTexts();
    GameControl gameControl = new GameControl();
    Dice dice = new Dice();
    Scanner sc = new Scanner(System.in);

    boolean isAppRunning = true;


    public void runApp() {

        texts.welcomeMessage();

        texts.numberOfPlayers();
        gameControl.setNumberOfPlayers();

        gameControl.namePlayers();

        texts.numberOfDice();
        gameControl.setNumberOfDies();

        texts.numberOfRounds();
        gameControl.setNumberOfRounds();

        texts.letsStartTheGame();

        // OBS i = 1 and <= in forloop!
        while (isAppRunning) {
            for (int i = 1; i <= gameControl.numberOfRounds; i++) {

                gameControl.resetAll();

                texts.getReadyForRound(i);
                gameControl.playRound();

                texts.showResult();
                gameControl.showResults();

                gameControl.findWinner();
                gameControl.findDraw();

                while (gameControl.isDraw) {
                    texts.welcomeToDraw();
                    gameControl.playDrawRound();
                    gameControl.findDrawWinner();
                    gameControl.resetDrawInAllObjectsInAllObjects();
                    gameControl.findDrawInDraw();
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
            gameControl.playAnotherRound();
        }
    }
}
