package com.OskarJohansson.DiceGameMkII;

public class GameControll {

    int rounds = 0;
    private int players = 0;
    UserInput scanner = new UserInput();

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

    public int setNumberOfPlayers() {
        int input = scanner.inputInt();
        while (input > 10) {
            System.out.println("Maximum number of players are 10! Try Again: ");
            input = scanner.inputInt();
        }
        this.players = input;

        return players;
    }

    public void showResult(){


    }
}
