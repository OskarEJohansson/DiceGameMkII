package com.OskarJohansson.DiceGameMkII.Control;

import com.OskarJohansson.DiceGameMkII.Model.Dice;
import com.OskarJohansson.DiceGameMkII.Model.Game;
import com.OskarJohansson.DiceGameMkII.Model.Player;

public class GameTexts {

    public void welcomeMessage() {
        String welcomeMessage = """
                                    
    WELCOME TO THE DICE GAME!
                                
           RULES
                    
    1. Set number of players to compete!
    2. Set number of dice to roll!
    3. Set number of rounds to play!
                                
      MAY THE BEST ROLLER WIN!
                        
    """;
        System.out.println(welcomeMessage);
    }

    public void getReadyForRound(int roundCounter) {
        System.out.printf("""
    Get ready for round
        >>> %d <<<
                                          
    """, roundCounter);
    }

    public void letsStartTheGame() {
        System.out.println("Let's start the game!\n");
    }

    public void numberOfPlayers() {
        System.out.print("Set number of players: ");
    }

    public void enterPlayerName(int numberOfPlayers) {
        System.out.print("Enter name of player " + numberOfPlayers + ": ");
    }

    public void numberOfDice() {
        System.out.print("Set number of dice to throw: ");
    }

    public void numberOfRounds() {
        System.out.print("Set number of rounds to play: ");
    }

    public void diceLoop(Player player, Dice dice) {
        System.out.printf("%s rolls >>> %d <<< with dice >>> %d <<<\n", player.getName(), player.getDiceRoll(), dice.getDiceCounter());
    }

    public void diceLoopDraw(Player player) {
        System.out.printf("%s rolls >>> %d <<<\n", player.getName(), player.getDrawScore());
    }

    public void showResult() {
        System.out.println("The results from this round are:");
    }

    public void showResultPlayer(Player player) {
        System.out.printf(">>> %s <<<\n>>> %d <<<\n", player.getName(), player.getScore());
    }

    public void showDrawResult() {
        System.out.println("The draw results are:");
    }

    public void showDrawResultPlayers(Player player) {
        System.out.printf(">>> %s <<<\n>>> %d <<<\n", player.getName(), player.getDrawScore());
    }

    public void theWinnerIs(Player player) {
        System.out.printf("""
    THE WINNER IS
    >>> %s <<<
                            
    with a total of
    >>> %d <<<       
    """, player.getName(), player.getScore());
    }

    public void theDrawWinnerIs(Player player) {
        System.out.printf("""
        
    THE DRAW WINNER IS
        >>> %s <<<
          with
        >>> %d <<<
    """, player.getName(), player.getDrawScore());
    }

    public void welcomeToDraw() {
        System.out.println("\nWE HAVE A DRAW\n");
    }

    public void playAnotherRound() {
        System.out.print("""
    Play another round?
                             
    >>> Y/N <<<
    Y to Continue
    N to exit the application.       
    """);
    }
}
