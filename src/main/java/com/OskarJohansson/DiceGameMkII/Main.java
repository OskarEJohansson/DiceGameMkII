package com.OskarJohansson.DiceGameMkII;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        // Objects
        UserInput scanner = new UserInput();
        Dice dice = new Dice();
        Random randomizer = new Random();
        Player player = new Player();
        ArrayList<Player> playerList = new ArrayList();


        // Variables
        boolean isAppRunning = true;

        // Start Game
        do {

            int numberOfPlayers = player.setNumberOfPlayers();

            // Name players
            for (int i = 0; i < numberOfPlayers; i++) {
                player = player.createPlayer();
                playerList.add(player);
            }

            // Set number of die to play with
            dice.setValue(scanner.inputInt());

            // Play a round of dice!
            for (int i = 0; i < numberOfPlayers; i++) {

                // Reset the summarizer for each player
                int sum = 0;

                for (int D = 1; D <= dice.value; D++) {
                    int throwDice = randomizer.nextInt(1, 7);
                    System.out.println(playerList.get(i) + " rolls >>> " + throwDice + " <<< with dice >>> " + D + " <<<");
                    sum += throwDice;
                    System.out.println("Press enter to roll again!");
                    scanner.inputString();
                }
                Player roll = playerList.get(i);
                roll.setResult(sum);
            }

            // Show results

            for (int i = 0; i < playerList.size(); i++) {
                Player playerScore = playerList.get(i);
                System.out.println(playerScore.getName() + " rolled a total of " + playerScore.getResult());
            }

            System.out.println("Press enter to continue");
            scanner.inputString();

            int[] score = new int[playerList.size()];
            // Show the winner of the round
            for (int i = 0; i < playerList.size(); i++) {
                player = playerList.get(i);
                score[i] = player.getResult();
            }
            System.out.println(Arrays.toString(score));


            // Look for a draw
//                if (winnerScore == result[i]) {
//                        System.out.println(" >>> DRAW <<< between " + winnerName + " and " + playerNames[i]
//                                           + """
//                                                    ON TO SUDDEN DEATH
//                                                   1 dice
//                                                   1 roll
//                                                   1 winner!""");
//
//
//                        String playerOne = winnerName;
//                        String playerTwo = playerNames[i];
//                        boolean suddenDeath = true;
//
//                        // If we have a draw we go to sudden death
//                        while (suddenDeath) {
//                            int playerOneRoll = randomizer.nextInt(1, 7);
//                            System.out.println(playerOne + " rolls >>> " + playerOneRoll + "\n");
//
//                            int playerTwoRoll = randomizer.nextInt(1, 7);
//
//                            System.out.println(playerTwo + " rolls >>> " + playerTwoRoll + "\n");
//
//                            if (playerOneRoll > playerTwoRoll) {
//                                System.out.println("THE WINNER IS " + playerOne);
//                                suddenDeath = false;
//                            } else if (playerOneRoll < playerTwoRoll) {
//                                System.out.println("THE WINNER IS " + playerTwo);
//                                suddenDeath = false;
//                            } else System.out.println("ANOTHER DRAW, BACK TO SUDDEN DEATH!");
//
//                        }
//                    }
//                }
//
//                //Prints out the name and points of the winner
//                System.out.println("The winner of the round is " + winnerName + " with a total of " + winnerScore + "\n");


            System.out.println("""
                    Play another round?
                    ENTER
                    >>> Y/N <<<
                    Y to Continue
                    N to exit Program.
                    """);

            if (scanner.inputString().equalsIgnoreCase("y")) {
                continue;
            } else isAppRunning = false;

        } while (isAppRunning);
    }
}