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
        Scanner sc = new Scanner(System.in);

        // Variables
        boolean isAppRunning = true;
        int winner = 0;
        String winnerName = "";
        int counter = 1;

        System.out.println("""
                                    
                WELCOME TO THE DICE GAME!
                                    
                         RULES
                        
                1. Set number of players to compete!
                2. Set number of dice to roll!
                3. Set number of rounds to play!
                                    
                  MAY THE BEST ROLLER WIN!
                        
                """);

        // Set number of players
        System.out.println("Set number of players to play : ");
        int numberOfPlayers = player.setNumberOfPlayers();

        // Name players
        for (int i = 0; i < numberOfPlayers; i++) {

            System.out.println("Enter name of player " + counter);
            player = player.createPlayer(sc.nextLine());
            playerList.add(player);
            counter++;

        }
        //Set number of die to play with
        System.out.println("Set number of dies to throw: ");
        dice.setValue();

        //Set number of rounds
        System.out.println("Set number of rounds to play: ");
        player.setRounds();

        // A loop to keep the app running
        while (isAppRunning) {

            counter = 1;
            // A function to keep track of rounds
            for (int a = 0; a < player.getRounds(); a++) {

                System.out.println("Let's start the game! \n Get ready for round >>> " + counter + " <<<");

                for (int i = 0; i < numberOfPlayers; i++) {

                    // Reset the summarizer for each player
                    int sum = 0;

                    // Retrieve the player object
                    Player getPlayer = playerList.get(i);
                    // Retrieve the player name
                    String playerName = getPlayer.getName(getPlayer);

                    for (int D = 1; D <= dice.value; D++) {

                        int throwDice = randomizer.nextInt(1, 7);

                        System.out.println(playerName + " rolls >>> " + throwDice + " <<< with dice >>> " + D + " <<<");
                        sum += throwDice;

                        // Break Button
                        System.out.println("Press enter to continue");
                        sc.nextLine();
                    }

                    getPlayer.setResult(sum);
                }

                //Show results
                for (Player getPlayer : playerList) {
                    // Iterate through all the players results
                    String playerName = getPlayer.getName(getPlayer);
                    int playerResult = getPlayer.getResult();
                    System.out.println(playerName + " rolled a total of " + playerResult + "\n");

                    // Look for a winner
                    if (winner < playerResult) {
                        winner = playerResult;
                        winnerName = playerName;

                        // WRITE A DRAW FUNCTION
                    }
                }

                System.out.println("THE WINNER IS " + winnerName + "\n");
                counter++;
            }

            System.out.println("""
                    Play another round?
                    ENTER
                    >>> Y/N <<<
                    Y to Continue
                    N to exit Program.
                    """);

            if (sc.nextLine().equalsIgnoreCase("y")) {
            } else isAppRunning = false;

        }
    }
}

