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

        // Set number of players
        int numberOfPlayers = player.setNumberOfPlayers();

        // Name players
        int whatPlayer = 1;
        for (int i = 0; i < numberOfPlayers; i++) {

            System.out.println("Enter name of player " + whatPlayer);
            player = player.createPlayer(sc.nextLine());
            playerList.add(player);
            whatPlayer++;
        }

        for (int k = 0; k < playerList.size(); k++) {

        }

        //Set number of die to play with
        System.out.println("Set number of dies to use in game: ");
        dice.setValue(scanner.inputInt());

        //Set number of rounds
        System.out.println("Set number of dies to use in game: ");
        player.setRounds(scanner.inputInt());


        // Play a round of dice!
        // Let's start the game!

        while (isAppRunning) {


            for (int a = 0; a < player.getRounds(); a++) {

                System.out.println(" Get ready for round >>> " + player.getRounds());

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

                        System.out.println("Press enter to continue");
                        sc.nextLine();

                    }

                    getPlayer.setResult(sum);
                }
                int winner = 0;
                String winnerName = "";

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
                    }

                }
                System.out.println("THE WINNER IS " + winnerName + "\n");
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

