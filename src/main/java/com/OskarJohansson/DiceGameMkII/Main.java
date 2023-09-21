package com.OskarJohansson.DiceGameMkII;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        // Objects
        UserInput scanner = new UserInput();
        GameControl gameControl = new GameControl();
        Dice dice = new Dice();
        Random randomizer = new Random();
        Player playerControllObject = new Player();

        Scanner sc = new Scanner(System.in);

        // Variables
        boolean isAppRunning = true;
        int winner = 0;
        String winnerName = "";
        boolean draw = false;
        int roundCounter = 1;

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
        int numberOfPlayers = gameControl.setNumberOfPlayers();

        // Name players
        for (int i = 0; i < numberOfPlayers; i++) {

            System.out.println("Enter name of player " + roundCounter);

            // Adds a player to Arraylist/playerList in GameControl
            playerControllObject = playerControllObject.createPlayer(sc.nextLine());
            gameControl.addPlayerToGame(playerControllObject);
            roundCounter++;

        }
        //Set number of die to play with
        System.out.println("Set number of dies to throw: ");
        dice.setValue();

        //Set number of rounds
        System.out.println("Set number of rounds to play: ");
        gameControl.setRounds();

        // A loop to keep the app running
        while (isAppRunning) {

            roundCounter = 1;
            // A function to keep track of rounds
            System.out.println("Let's start the game!");
            for (int roundsLoop = 0; roundsLoop < gameControl.getRounds(); roundsLoop++) {

                System.out.println("Get ready for round >>> " +
                                   roundCounter +
                                   " <<<");

                for (int playerLoop = 0; playerLoop < numberOfPlayers; playerLoop++) {

                    // Reset the summarizer for each player
                    int sum = 0;

                    // Retrieve the player object from GameControl / playerList
                    Player getPlayer = gameControl.getPlayerInPlayerList(playerLoop);
                    // Retrieve the player name
                    String playerName = getPlayer.getName(getPlayer);

                    // A loop to throw a die and save the result.
                    int diceCounter = 1;
                    for (int diceLoop = 0; diceLoop < dice.value; diceLoop++) {

                        int throwDice = randomizer.nextInt(1, 7);

                        System.out.println(playerName + " rolls >>> " + throwDice + " <<< with dice >>> " + diceCounter + " <<<");
                        sum += throwDice;

                        // Break Button
                        System.out.println("Press enter to continue");
                        sc.nextLine();
                        diceCounter++;
                    }
                    getPlayer.setResult(sum);
                }

                //Show results
                for (Player getPlayer : gameControl.getPlayerList()) {
                    // Iterate through all the players results
                    String playerName = getPlayer.getName(getPlayer);
                    int playerResult = getPlayer.getResult();
                    System.out.println(playerName + " rolled a total of " + playerResult + "\n");

                    // Look for a winner
                    if (winner < playerResult) {
                        winner = playerResult;

                    } else if (playerResult == winner) {
                        draw = true;

                        while (draw) {
                            String drawPlayerOne = winnerName;
                            String drawPlayerTwo = playerName;
                            System.out.println(" >>> WE HAVE A DRAW BETWEEN! <<< \n" + drawPlayerOne + " AND " + drawPlayerTwo);

                            System.out.println(">>> RULSES <<< \n >>> ONE T6-DICE  <<< \n >>> ONE ROLL <<< \n >>> ONE WINNER <<<");

                            int throwDice = randomizer.nextInt(1, 7);
                            int drawPlayerOneResult = throwDice;

                            System.out.println(drawPlayerOne + " rolls >>> " + throwDice);
                            throwDice = randomizer.nextInt(1, 7);

                            int drawPlayerTwoResult = throwDice;
                            System.out.println(playerName + " rolls >>> " + throwDice + "\n");

                            if (drawPlayerOneResult > drawPlayerTwoResult) {
                                System.out.println(" THE WINNER IS " + drawPlayerOne + "\n");
                                draw = false;
                                break;
                            } else if (drawPlayerOneResult < drawPlayerTwoResult) {
                                System.out.println(" THE WINNER IS " + drawPlayerTwo + "\n");
                                draw = false;
                                break;
                            } else System.out.println(" ANOTHER DRAW! \n");
                        }

                    }
                    winnerName = playerName;
                }

                System.out.println("THE WINNER IS \n" + ">>> " + winnerName + " <<<" + "\n");
                roundCounter++;
            }

            System.out.println("""
                    Play another round?
                    ENTER
                    >>> Y/N <<<
                    Y to Continue
                    N to exit the application.
                    """);

            if (sc.nextLine().equalsIgnoreCase("y")) {
            } else isAppRunning = false;

        }
    }
}

