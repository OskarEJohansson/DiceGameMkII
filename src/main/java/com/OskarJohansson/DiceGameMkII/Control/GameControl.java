package com.OskarJohansson.DiceGameMkII.Control;

import com.OskarJohansson.DiceGameMkII.Model.Dice;
import com.OskarJohansson.DiceGameMkII.Model.Player;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class GameControl {

    int numberOfRounds = 0;
    int numberOfPlayers = 0;
    int counter = 1;
    int input;
    int winnerScore;
    int drawWinnerScore;
    Player winnerObject;
    Player drawWinnerObject;

    boolean isDraw = false;
    boolean appIsRunning = true;


    public void setNumberOfPlayers(Scanner scanner, UserInput userInput) {
        int maxNumber = 10;
        String noun = "players";
        while (userInput.maxNumberOfInput(this.input = userInput.inputInt(scanner), noun, maxNumber)) {
            scanner.next();
        }
        this.numberOfPlayers = input;
    }

    public void setNumberOfDies(Dice dice, UserInput userInput, Scanner scanner) {
        int maxNumber = 10;
        String noun = "dies";
        while (userInput.maxNumberOfInput(this.input = userInput.inputInt(scanner), noun, maxNumber)) {
            scanner.next();
        }
        dice.setNumberOfDice(input);
    }

    public Player createPlayer(Player player, String name) {
        player.setName(name);
        return player;
    }

    public ArrayList<Player> namePlayers(ArrayList<Player> playerList, Scanner scanner, GameTexts texts) {
        for (int i = 0; i < this.numberOfPlayers; i++) {
            texts.enterPlayerName(this.counter);
            Player player = new Player();
            playerList.add(createPlayer(player, scanner.nextLine()));
            counter++;
        }
        this.counter = 1;
        return playerList;
    }

    public void setNumberOfRounds(@NotNull UserInput userInput, Scanner scanner) {
        int maxNumber = 10;
        String noun = "rounds";
        while (userInput.maxNumberOfInput(this.input = userInput.inputInt(scanner), noun, maxNumber)) {
            scanner.next();
        }
        this.numberOfRounds = input;
    }

    public void playRound(ArrayList<Player> playerList, Player player, Dice dice, Scanner scanner) {
        for (int i = 0; i < this.numberOfPlayers; i++) {
            player = playerList.get(i);
            diceLoop(player, dice, scanner);
            dice.resetDiceCounter();
        }
    }
    public void diceLoop(Player player, Dice dice, Scanner scanner) {
        if (isDraw) {
            player.setDrawScore(dice.throwDice());
            System.out.println(player.getName() + " rolls >>> " + player.getDrawScore());
        } else
            for (int i = 0; i < dice.getNumberOfDice(); i++) {
                System.out.println(player.getName() + " rolls >>> " + player.setDiceRoll(dice.throwDice()) + " <<< with dice >>> " + dice.getDiceCounter() + " <<<");
                player.setScore();
                dice.addToDiceCounter();
                breakButton(scanner);
            }
    }

    public void findWinner(@NotNull ArrayList<Player> playerList) {
        for (Player player : playerList) {
            while (isDraw) {
                if (player.getDrawScore() > drawWinnerScore) {
                    this.drawWinnerScore = player.getDrawScore();
                    this.drawWinnerObject = player;
                }
            }
            if (player.getScore() > winnerScore) {
                this.winnerScore = player.getScore();
                this.winnerObject = player;
            }
        }
    }

    public void showResults(@NotNull ArrayList<Player> playerList) {
        for (Player player : playerList) {
            System.out.println(">>> Score <<<");
            System.out.println(player.getName() + ": " + player.getScore() + " points. \n");
        }
    }

    public void playDrawRound(Dice dice, ArrayList<Player> playerList, Scanner scanner) {
        if (isDraw)
            for (Player player : playerList) {
                if (player.getDraw()) {
                    diceLoop(player, dice, scanner);
                }
            }
    }

    public void findDraw(@NotNull ArrayList<Player> playerList) {

        for (Player player : playerList) {

            while (player.getDraw()) {

                if (player.getDrawScore() == this.winnerObject.getDrawScore() && !Objects.equals(player.getName(), this.winnerObject.getName())) {
                    player.setDraw(true);
                    this.winnerObject.setDraw(true);
                    this.isDraw = true;
                }
            }
            if (player.getScore() == this.winnerObject.getScore() && !Objects.equals(player.getName(), this.winnerObject.getName())) {
                player.setDraw(true);

                this.winnerObject.setDraw(true);
                this.isDraw = true;
            }
        }
    }
    public void resetScoreInAllObjects(@NotNull ArrayList<Player> playerList) {
        for (Player player : playerList) {
            player.resetScore();
        }
    }
    public void resetDrawWinnerScoreInAllObjects(@NotNull ArrayList<Player> playerList) {
        for (Player player : playerList) {
            player.resetDrawScore();
        }
    }
    public void resetDrawInAllObjectsInAllObjects(@NotNull ArrayList<Player> playerList) {
        for (Player player : playerList) {
            player.resetDraw();
        }
    }
    public void resetAll(ArrayList<Player> playerList) {
        resetScoreInAllObjects(playerList);
        resetDrawWinnerScoreInAllObjects(playerList);
        resetDrawInAllObjectsInAllObjects(playerList);
        this.winnerScore = 0;
        this.drawWinnerObject = new Player();
        this.winnerObject = new Player();
    }

    public void resetRoundWin(@NotNull ArrayList<Player> playerList) {
        for (Player player : playerList) {
            player.resetRoundWin();
        }
    }
    public void breakButton(@NotNull Scanner scanner) {
        System.out.println("Press 'Enter' to continue");
        scanner.nextLine();
    }
    public void playAnotherRound(@NotNull Scanner scanner) {
        this.appIsRunning = scanner.nextLine().equalsIgnoreCase("y");
    }
}
