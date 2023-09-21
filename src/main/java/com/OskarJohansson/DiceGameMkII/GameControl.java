package com.OskarJohansson.DiceGameMkII;

import java.util.ArrayList;

public class GameControl {

    int rounds = 0;
    private int players = 0;
    UserInput scanner = new UserInput();
    ArrayList<Player> playerList = new ArrayList();

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

    public void addPlayerToGame(Player player){
        this.playerList.add(player);
    }

    public Player getPlayerInPlayerList(int playerIndex){
        return this.playerList.get(playerIndex);
    }

    public ArrayList<Player> getPlayerList(){
        return this.playerList;
    }
}
