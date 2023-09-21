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
    int winnerAllRounds;
    int drawWinnerScore;
    Player winnerObject;
    Player winnerAllRoundsObject;
    Player drawWinnerObject;
    boolean isDraw = false;
    boolean appIsRunning = true;

    UserInput userInput = new UserInput();
    ArrayList<Player> playerList = new ArrayList();
    ArrayList<Player> drawList = new ArrayList<>();
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

    public void setnumberOfDies() {
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

        for (int i = 0; i < this.numberOfDies; i++) {

            System.out.println(player.getName() + " rolls >>> " + player.setDiceRoll(dice.throwDice()) + " <<< with dice >>> " + dice.getDiceCounter() + " <<<");
            player.setScore();
            dice.addToDiceCounter();
            breakButton();
        }
    }

    public void findWinner() {
        for (Player player : this.playerList) {

            if (player.getScore() > winnerScore ) {
                this.winnerObject = player;
            }
        }
    }

    public void showResults() {
        for (Player player : this.playerList) {
            // Iterate through all the players results
            System.out.println(player.getName() + ": " + player.getScore() + " points. \n");
            breakButton();
        }
    }

    public void playDrawRound() {
        if (drawList != null)
            for (Player player : this.drawList) {
                diceLoopDraw(player);
            }
    }

    public void diceLoopDraw(Player player) {
        player.setDrawScore(dice.throwDice());
        System.out.println(player.getName() + " rolls >>> " + player.getDrawScore());
    }


    public void findDrawWinner() {
        for (Player player : this.drawList) {

            if (player.getDrawScore() > drawWinnerScore) {
                this.drawWinnerObject = player;
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

    public void addToDrawRound() {
        for (Player player : this.playerList) {
            if (player.getDraw() == true) {
                drawList.add(player);
            }
        }
    }



    public void findDrawInDraw() {
        for (Player player : this.drawList) {
            if (player.getDrawScore() == this.drawWinnerObject.getDrawScore() && !Objects.equals(player.getName(), this.drawWinnerObject.getName())) {
                player.setDraw(true);
                this.drawWinnerObject.setDraw(true);
                this.isDraw = true;
            }
        }
        this.isDraw = false;
    }

    public void resetDrawInAllObjects() {
        for (Player player : this.drawList) {
            player.setDraw(false);
        }
    }

    public void findWinnerAllRounds(){
        for (Player player : playerList){

            if(player.getRoundWin() > winnerAllRounds){
                this.winnerAllRoundsObject = player;
            }
        }
    }

    public void resetScore(){
        for (Player player : this.playerList) {
            player.setScore(0);
        }
    }

    public void resetRoundWin() {
        for (Player player : this.playerList) {
            player.setRoundWin(0);
        }
    }

    public void breakButton() {
        System.out.println("Press 'Enter' to continue");
        sc.nextLine();
    }

    public void playAnotherRound() {
        if (sc.nextLine().equalsIgnoreCase("y")) {
        } else appIsRunning = false;
    }

}
