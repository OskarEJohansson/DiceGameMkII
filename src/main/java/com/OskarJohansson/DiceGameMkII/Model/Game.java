package com.OskarJohansson.DiceGameMkII.Model;

import java.util.ArrayList;

public class Game {

    int numberOfRounds;
    int numberOfPlayers;
    int counter;
    int winnerScore;
    ArrayList<Player> playerList;
    Player winnerObject;

    public Game(){
        this.numberOfRounds = 0;
        this.numberOfPlayers = 0;
        this.counter = 1;
        this.winnerScore = 0;
        this.playerList = new ArrayList<Player>();
        this.winnerObject= new Player();
    }

    public int getNumberOfRounds() {
        return numberOfRounds;
    }

    public void setNumberOfRounds(int numberOfRounds) {
        this.numberOfRounds = numberOfRounds;
    }

    public int getNumberOfPlayers() {
        return numberOfPlayers;
    }

    public void setNumberOfPlayers(int numberOfPlayers) {
        this.numberOfPlayers = numberOfPlayers;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public void resetCounter(int counter) {
        this.counter = counter;
    }

    public void addToCounter(){
        this.counter++;
    }

    public int getWinnerScore() {
        return winnerScore;
    }

    public void setWinnerScore(int winnerScore) {
        this.winnerScore = winnerScore;
    }

    public void resetWinnerScore() {
        this.winnerScore = 0;
    }

    public Player getWinnerObject() {
        return winnerObject;
    }

    public ArrayList<Player> getPlayerList() {
        return playerList;
    }

    public void setPlayerList(ArrayList<Player> playerList) {
        this.playerList = playerList;
    }

    public void setWinnerObject(Player winnerObject) {
        this.winnerObject = winnerObject;
    }

    public void resetWinnerObject() {
        this.winnerObject = new Player();
    }


}
