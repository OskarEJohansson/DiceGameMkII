package com.OskarJohansson.DiceGameMkII.Control;

import com.OskarJohansson.DiceGameMkII.Control.GameControl.*;
import com.OskarJohansson.DiceGameMkII.Model.Dice;
import com.OskarJohansson.DiceGameMkII.Model.Game;
import com.OskarJohansson.DiceGameMkII.Model.Player;

import java.util.Scanner;
import java.util.Set;

public class GameFlow {


    GameTexts texts;
    Game game;
    Player player;
    Dice dice;
    Scanner scanner;
    UserInput userInput;
    boolean isAppRunning;

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

            for (int i = 0; i < game.getNumberOfRounds(); i++) {

                resetParameters.resetAll(game); // Not working properly

                texts.getReadyForRound(game.getCounter());
                playRound.playRound(game, dice, texts, scanner);

                gameResults.showResults(game, texts);

                gameResults.findWinner(game);
                gameResults.findDraw(game);

                while (game.isDraw()) {

                    texts.welcomeToDraw();
                    playRound.playDrawRound(game, dice, texts, scanner);
                    playRound.breakButton(scanner);
                    resetParameters.resetDrawInAllObjectsInAllObjects(game);
                }

                if (game.isDraw()) {
                    texts.theWinnerIs(game.getDrawWinnerObject().getName(), game.getDrawWinnerObject().getDrawScore());
                    player.setRoundWin();

                } else {
                    texts.theWinnerIs((game.getWinnerObject().getName()), game.getWinnerObject().getScore());
                    player.setRoundWin();
                }
            }
        }
        texts.playAnotherRound();
        playRound.playAnotherRound(scanner);
    }
}

