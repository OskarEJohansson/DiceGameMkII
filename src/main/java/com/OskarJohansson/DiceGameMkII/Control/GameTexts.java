package com.OskarJohansson.DiceGameMkII.Control;

import com.OskarJohansson.DiceGameMkII.Model.Dice;
import com.OskarJohansson.DiceGameMkII.Model.Game;
import com.OskarJohansson.DiceGameMkII.Model.Player;

public class GameTexts {

    public void welcomeMessage() {

        System.out.println("""
                                    
                WELCOME TO THE DICE GAME!
                                    
                         RULES
                        
                1. Set number of players to compete!
                2. Set number of dice to roll!
                3. Set number of rounds to play!
                                    
                  MAY THE BEST ROLLER WIN!
                        
                """);
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
        System.out.println("Set number of players: ");
    }

    public void enterPlayerName(int numberOfPlayers) {
        System.out.println("Enter name of player " + numberOfPlayers);
    }

    public void numberOfDice() {
        System.out.println("Set number of dies to throw: ");
    }

    public void numberOfRounds() {
        System.out.println("Set number of rounds to play: ");
    }

    public void diceLoop(Player player, Dice dice) {
        System.out.println(player.getName() + " rolls >>> " + player.getDiceRoll() + " <<< with dice >>> " + dice.getDiceCounter() + " <<<");
    }

    public void diceLoopDraw(Player player) {
        System.out.println(player.getName() + " rolls >>> " + player.getDrawScore());
    }

    public void showResult() {
        System.out.printf("""         
                The results from this round is:  
                """);
    }
    public void showResultPlayer(Player player) {
        System.out.printf("""
                >>> %s <<< 
                >>> %d <<< 
                """, player.getName(), player.getScore());

    }

    public void showDrawResult() {
        System.out.printf(""" 
                The draw results is: 
                """);
    }

    public void showDrawResultPlayers(Player player) {
        System.out.printf("""
                >>> %s <<< 
                >>> %d <<< 
                """, player.getName(), player.getDrawScore());
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
                  with a total of
                    >>> %d <<<
                """, player.getName(), player.getDrawScore());
    }

    public void welcomeToDraw() {
        System.out.println("\nWE HAVE A DRAW \n");
    }

    public void playAnotherRound() {
        System.out.println("""
                Play another round?
                                 
                >>> Y/N <<<
                Y to Continue
                N to exit the application.       
                """);
    }
}
