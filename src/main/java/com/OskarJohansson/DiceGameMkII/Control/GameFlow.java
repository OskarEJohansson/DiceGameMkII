package com.OskarJohansson.DiceGameMkII.Control;

import com.OskarJohansson.DiceGameMkII.Model.Dice;

import java.util.Scanner;

public class GameFlow {

    GameTexts texts = new GameTexts();
    GameControl gameControl = new GameControl();
    Dice dice = new Dice();
    Scanner sc = new Scanner(System.in);

    boolean isAppRunning = true;


    public void runApp(){

        texts.welcomeMessage();

        texts.numberOfPlayers();
        gameControl.setNumberOfPlayers();

        gameControl.namePlayers();

        texts.numberOfDice();
        gameControl.setnumberOfDies();

        texts.numberOfRounds();
        gameControl.setNumberOfRounds();



        texts.letsStartTheGame();
        for (int i = 1; i <= gameControl.numberOfRounds ; i++) {

            gameControl.resetAll();

            texts.getReadyForRound(i);

            gameControl.playRound();
            gameControl.showResults();

            gameControl.findWinner();
            gameControl.findDraw();

            while (gameControl.isDraw) {
                texts.welcomeToDraw();
                gameControl.addToDrawRound();
                gameControl.playDrawRound();
                gameControl.findDrawWinner();
                gameControl.resetDrawInAllObjects();
                gameControl.findDrawInDraw();
            }

            if (!gameControl.drawList.isEmpty()) {
                texts.theWinnerIs(gameControl.drawWinnerObject.getName(), gameControl.drawWinnerScore);
                gameControl.drawWinnerObject.setRoundWin(1);

            } else {

                texts.theWinnerIs(gameControl.winnerObject.getName(), gameControl.winnerObject.getScore());
                gameControl.winnerObject.setRoundWin(1);
            }

        }

        gameControl.findWinnerAllRounds();
        texts.theWinnerOfAllRounds(gameControl.winnerAllRoundsObject.getName(), gameControl.winnerAllRoundsObject.getRoundWin());

        gameControl.resetRoundWin();
        texts.playAnotherRound();
        gameControl.playAnotherRound();
    }
}
