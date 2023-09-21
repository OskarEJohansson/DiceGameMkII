package com.OskarJohansson.DiceGameMkII;

public class Player {

    private String name;
    private int score = 0;

    UserInput scanner = new UserInput();

    // Get Player Name
    public String getName(Player player) {
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

    public Player createPlayer(String name) {
        Player player = new Player();
        player.name = name;
        return player;
    }

}



