package com.OskarJohansson.DiceGameMkII.Control;

import com.OskarJohansson.DiceGameMkII.Model.Dice;
import com.OskarJohansson.DiceGameMkII.Model.Player;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class GameControl {

    int numberOfRounds = 0;
    int numberOfPlayers = 0;
    int numberOfDies = 1;
    int counter = 1;
    int input;
    int winnerScore;
    int drawWinnerScore;
    Player winnerObject;
    Player drawWinnerObject;
    boolean isDraw = false;
    boolean appIsRunning = true;

    UserInput userInput = new UserInput();
    ArrayList<Player> playerList = new ArrayList<>();
    GameTexts texts = new GameTexts();
    Scanner sc = new Scanner(System.in);
    Dice dice = new Dice();

    public void setNumberOfPlayers() {
        int maxNumber = 10;
        String noun = "players";
        while (userInput.maxNumberOfInput(this.input = userInput.inputInt(), noun, maxNumber)) {
            sc.next();
        }
        this.numberOfPlayers = input;
    }

    public void setNumberOfDies() {
        int maxNumber = 10;
        String noun = "dies";
        while (userInput.maxNumberOfInput(this.input = userInput.inputInt(), noun, maxNumber)) {
            sc.next();
        }
        this.numberOfDies = input;
    }

    public Player createPlayer(String name) {
        Player player = new Player();
        player.setName(name);
        return player;
    }

    public void namePlayers() {
        for (int i = 0; i < this.numberOfPlayers; i++) {
            texts.enterPlayerName(this.counter);
            this.playerList.add(createPlayer(sc.nextLine()));
            counter++;
        }
        this.counter = 1;
    }

    public void setNumberOfRounds() {
        int maxNumber = 10;
        String noun = "rounds";

        while (userInput.maxNumberOfInput(this.input = userInput.inputInt(), noun, maxNumber)) {
            sc.next();
        }
        this.numberOfRounds = input;
    }

    public void playRound() {
        for (int i = 0; i < this.numberOfPlayers; i++) {

            Player player = this.playerList.get(i);
            diceLoop(player);
            dice.resetDiceCounter();
        }
    }

    public void diceLoop(Player player) {

        if (isDraw) {

            player.setDrawScore(dice.throwDice());
            System.out.println(player.getName() + " rolls >>> " + player.getDrawScore());

        } else

            for (int i = 0; i < this.numberOfDies; i++) {

                System.out.println(player.getName() + " rolls >>> " + player.setDiceRoll(dice.throwDice()) + " <<< with dice >>> " + dice.getDiceCounter() + " <<<");
                player.setScore();
                dice.addToDiceCounter();
                breakButton();
            }
    }

    public void findWinner() {
        for (Player player : this.playerList) {

            if (player.getScore() > winnerScore) {
                this.winnerScore = player.getScore();
                this.winnerObject = player;
            }
        }
    }

    public void showResults() {
        for (Player player : this.playerList) {
            System.out.println(">>> Score <<<");
            System.out.println(player.getName() + ": " + player.getScore() + " points. \n");
        }
    }

    public void playDrawRound() {
        if (isDraw)
            for (Player player : this.playerList) {
                if (player.getDraw()) {
                    diceLoop(player);
                }
            }
    }


    public void findDraw() {
        for (Player player : this.playerList) {
            if (player.getScore() == this.winnerObject.getScore() && !Objects.equals(player.getName(), this.winnerObject.getName())) {
                player.setDraw(true);
                this.winnerObject.setDraw(true);
                this.isDraw = true;
            }
        }
    }

    public void findDrawInDraw() {
        for (Player player : this.playerList) {

            if (player.getDrawScore() == this.drawWinnerObject.getDrawScore() && !Objects.equals(player.getName(), this.drawWinnerObject.getName())) {

                player.setDraw(true);
                this.drawWinnerObject.setDraw(true);
                this.isDraw = true;
            }
        }
        this.isDraw = false;
    }

    public void findDrawWinner() {
        for (Player player : this.playerList) {

            if (player.getDrawScore() > drawWinnerScore) {

                this.drawWinnerScore = player.getDrawScore();
                this.drawWinnerObject = player;
            }
        }
    }

    public void resetScoreInAllObjects() {
        for (Player player : this.playerList) {
            player.resetScore();
        }
    }

    public void resetDrawWinnerScoreInAllObjects() {
        for (Player player : this.playerList) {
            player.resetDrawScore();
        }
    }

    public void resetDrawInAllObjectsInAllObjects() {
        for (Player player : this.playerList) {
            player.resetDraw();
        }
    }

    public void resetAll() {
        resetScoreInAllObjects();
        resetDrawWinnerScoreInAllObjects();
        resetDrawInAllObjectsInAllObjects();
        this.winnerScore = 0;
        this.drawWinnerObject = new Player();
        this.winnerObject = new Player();
    }

    public void resetRoundWin() {
        for (Player player : this.playerList) {
            player.resetRoundWin();
        }
    }

    public void breakButton() {
        System.out.println("Press 'Enter' to continue");
        sc.nextLine();
    }

    public void playAnotherRound() {
        this.appIsRunning = sc.nextLine().equalsIgnoreCase("y");
    }

}
