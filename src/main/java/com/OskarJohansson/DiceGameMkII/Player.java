package com.OskarJohansson.DiceGameMkII;

import java.util.ArrayList;
import java.util.Scanner;

public class Player {

    private String name;
    private int score = 0;
    private int players = 0;
    UserInput scanner = new UserInput();


    // Get Player Name
    public String getName() {
        return name;
    }

    // Set Player Name
    public void setName(String name) {
        this.name = name;
    }

    // Get Player Result
    public int getResult() {
        return score;
    }

    // Set Player result
    public void setResult(int result) {
        this.score = result;
    }

    public Player createPlayer() {
        Player player = new Player();
        System.out.println("Enter player name");
        player.name = scanner.inputString();
        return player;
    }

    public int setNumberOfPlayers() {
        System.out.println("Set number of players: ");
        this.players = scanner.inputInt() ;
        return players;
    }
}



