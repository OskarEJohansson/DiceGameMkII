package com.OskarJohansson.DiceGameMkII;

public class Player {

    private String name;
    private int score = 0;
    private int players = 0;
    private int rounds = 0;


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

    public int getRounds() {
        return rounds;
    }

    public void setRounds() {
        int input = scanner.inputInt();
        while (input > 10) {
            System.out.println("Maximum number of rounds are 10! Try Again: ");
            input = scanner.inputInt();
        }
        this.rounds = input;
    }

    public Player createPlayer(String name) {
        Player player = new Player();
        player.name = name;
        return player;
    }

    public int setNumberOfPlayers() {
        int input = scanner.inputInt();
        while (input > 10) {
            System.out.println("Maximum number of players are 10! Try Again: ");
            input = scanner.inputInt();
        }
        this.players = input;

        return players;
    }
}



