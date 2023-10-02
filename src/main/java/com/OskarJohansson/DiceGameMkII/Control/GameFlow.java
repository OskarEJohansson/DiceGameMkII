package com.OskarJohansson.DiceGameMkII.Control;

import com.OskarJohansson.DiceGameMkII.Control.GameControl.*;
import com.OskarJohansson.DiceGameMkII.Model.Dice;
import com.OskarJohansson.DiceGameMkII.Model.Draw;
import com.OskarJohansson.DiceGameMkII.Model.Game;
import com.OskarJohansson.DiceGameMkII.Model.Player;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.TimeoutException;

public class GameFlow {


    GameTexts texts;
    Game game;
    Player player;
    Dice dice;
    Scanner scanner;
    UserInput userInput;
    boolean isAppRunning;
    Draw draw;

    SetGameParameters setGameParameters;
    CreatePlayer createPlayer;
    PlayRound playRound;
    GameResults gameResults;
    ResetParameters resetParameters;

    public GameFlow() {

        this.texts = new GameTexts();
        this.game = new Game();
        this.player = new Player();
        this.dice = new Dice();
        this.scanner = new Scanner(System.in);
        this.userInput = new UserInput();
        this.isAppRunning = true;
        this.draw = new Draw();

        this.setGameParameters = new SetGameParameters();
        this.createPlayer = new CreatePlayer();
        this.playRound = new PlayRound();
        this.gameResults = new GameResults();
        this.resetParameters = new ResetParameters();

    }

    public void runApp() {

        texts.welcomeMessage();

        texts.numberOfPlayers();

        setGameParameters.setNumberOfPlayers(game, userInput, scanner);

        createPlayer.namePlayers(game, texts, scanner);

        texts.numberOfDice();
        setGameParameters.setNumberOfDies(dice, userInput, scanner);

        texts.numberOfRounds();
        setGameParameters.setNumberOfRounds(game, userInput, scanner);

        texts.letsStartTheGame();

        while (isAppRunning) {

            game.resetCounter(1);

            for (int i = 0; i < game.getNumberOfRounds(); i++) {

                // Reset all the parameters for next round
                texts.getReadyForRound(game.getCounter());
                playRound.playRound(game, dice, texts, draw, scanner);

                texts.showResult();
                gameResults.showResults(game, texts);

                gameResults.findWinner(game);
                gameResults.findDraw(game, draw);

                while (draw.getDraw() == 1) {

                    texts.welcomeToDraw();
                    playRound.playDrawRound(dice, texts, draw, scanner);
                    gameResults.findWinnerInDraw(draw);
                    gameResults.findDrawInDraw(game, draw);

                }
                // 1 == show dra winner.
                if (draw.getShowDrawWinner() == 1) {
                    texts.theDrawWinnerIs(draw.getDrawWinnerObject());
                    draw.setShowDrawWinner(0);



                    // Shows the normal round winner if "draw.getShowDrawWinner == 0)
                } else {
                    texts.theWinnerIs(game.getWinnerObject());
                    game.getWinnerObject().setRoundWin();
                }

                game.addToCounter();
                game.resetWinnerObject();
                game.resetWinnerScore();
                draw.resetDrawWinnerObject();
                draw.resetDrawPlayerList();
                resetParameters.resetScoreInAllObjects(game);
                resetParameters.resetDrawScoreInAllObjects(game);

            }
            texts.playAnotherRound();
            isAppRunning = setGameParameters.playAnotherRound(scanner, isAppRunning);
        }
    }
}

