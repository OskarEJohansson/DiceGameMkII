package com.OskarJohansson.DiceGameMkII;

import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // Objects
        Player player = new Player();
        UserInput scanner = new UserInput();
        Dice dice = new Dice();
        Scanner sc = new Scanner(System.in);
        Random randomizer = new Random();

        // Variables
        boolean isAppRunning = true;
        int numberOfPlayers = 0;

        // For determining a winner
        int winnerScore = 0;
        String winnerName = "";

        // Integer to show what player to name
        int whatPlayer = 1;


        do {

            System.out.println("Set number of players: ");
            numberOfPlayers = scanner.inputInt();
            String[] playerNames = new String[numberOfPlayers];

            System.out.println("Set number of dies to use in game: ");
            dice.setValue(scanner.inputInt());

            // This function names the players in the game and save them to an ArrayList<String>
            for (int i = 0; i < numberOfPlayers; i++) {
                System.out.println("Enter the name of player " + whatPlayer + ": ");
                String playerName = sc.nextLine();
                player.setName(playerName);
                playerNames[i] = playerName;
                whatPlayer++;
            }

            // Variable to save the total sum the round for each player
            int sum = 0;

            // A list to save the result for each player in the round
            int[] result = new int[numberOfPlayers];

            // Play a round of dice!
            for (int i = 0; i < numberOfPlayers; i++) {

                // Reset the summarizer for each player
                sum = 0;

                for (int D = 1; D <= dice.value; D++) {
                    int throwDice = randomizer.nextInt(1, 7);
                    System.out.println(playerNames[i] + " rolls >>> " + throwDice + " <<< with dice >>> " + D + " <<<");
                    sum += throwDice;
                    System.out.println("Press enter to roll again!");
                    sc.nextLine();
                }

                // Saves the result to the result list after each round
                result[i] = sum;
            }

            // Show results
            for (int j = 0; j < numberOfPlayers; j++) {
                System.out.println(playerNames[j] + " rolled a total of " + result[j] + "\n");
            }

            System.out.println("Press enter to continue");
            sc.nextLine();


            // Show the winner of the round
            for (int i = 0; i < result.length; i++) {

                if (winnerScore < result[i]) {
                    winnerScore = result[i];
                    winnerName = playerNames[i];

                    // Look for a draw
                    if (winnerScore == result[i]) {
                        System.out.println(" >>> DRAW <<< between " + winnerName + " and " + playerNames[i]
                                           + """
                                                    ON TO SUDDEN DEATH
                                                   1 dice
                                                   1 roll
                                                   1 winner!""");


                        String playerOne = winnerName;
                        String playerTwo = playerNames[i];
                        boolean suddenDeath = true;

                        // If we have a draw we go to sudden death
                        while (suddenDeath) {
                            int playerOneRoll = randomizer.nextInt(1, 7);
                            System.out.println(playerOne + " rolls >>> " + playerOneRoll + "\n");

                            int playerTwoRoll = randomizer.nextInt(1, 7);

                            System.out.println(playerTwo + " rolls >>> " + playerTwoRoll + "\n");

                            if (playerOneRoll > playerTwoRoll) {
                                System.out.println("THE WINNER IS " + playerOne);
                                suddenDeath = false;
                            } else if (playerOneRoll < playerTwoRoll) {
                                System.out.println("THE WINNER IS " + playerTwo);
                                suddenDeath = false;
                            } else System.out.println("ANOTHER DRAW, BACK TO SUDDEN DEATH!");

                        }
                    }
                }

                //Prints out the name and points of the winner
                System.out.println("The winner of the round is " + winnerName + " with a total of " + winnerScore + "\n");


                System.out.println("""
                        Play another round?
                        ENTER
                        >>> Y/N <<<
                        Y to Continue
                        N to exit Program.
                        """);

                if (sc.nextLine().equalsIgnoreCase("y")) {
                    continue;
                } else isAppRunning = false;

            }
        } while (isAppRunning);
    }
}