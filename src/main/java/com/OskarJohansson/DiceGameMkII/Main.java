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


        do {

            System.out.println("Set number of players: ");
            numberOfPlayers = scanner.inputInt();
            String[] playerNames = new String[numberOfPlayers];

            System.out.println("Set number of dies to use in game: ");
            dice.setValue(scanner.inputInt());

            // Integer to show what player to name
            int whatPlayer = 1;

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
                    System.out.println("Player " + playerNames[i] + " rolls >>> " + throwDice + " <<< with dice >>> " + D + " <<<");
                    sum += throwDice;
                    System.out.println(sum);
                    System.out.println("Press enter to continue");
                    sc.nextLine();
                }

                // Saves the result to the result list after each round
                result[i] = sum;
            }

            // Show results
            for (int j = 0; j < numberOfPlayers; j++) {
                System.out.println("Player " + playerNames[j] + " rolled a total of " + result[j]);
            }

            int winner = 0;
            // Show the winner of the round
            for (int i = 0; i < numberOfPlayers; i++) {
                if (winner < result[i]){
                    winner = result[i];
                }



            }

        } while (isAppRunning);
    }
}
