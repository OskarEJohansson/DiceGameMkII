package com.OskarJohansson.DiceGameMkII.Control;

import com.OskarJohansson.DiceGameMkII.Model.Dice;
import com.OskarJohansson.DiceGameMkII.Model.Game;
import com.OskarJohansson.DiceGameMkII.Model.Player;

public class GameTexts {

    public void welcomeMessage(){

        System.out.println("""
                                    
                WELCOME TO THE DICE GAME!
                                    
                         RULES
                        
                1. Set number of players to compete!
                2. Set number of dice to roll!
                3. Set number of rounds to play!
                                    
                  MAY THE BEST ROLLER WIN!
                        
                """);
    }


    public void getReadyForRound(int roundCounter){
        System.out.printf("""
                Get ready for round
                >>> %d <<<
                                          
                """, roundCounter);
    }
    public void letsStartTheGame(){
        System.out.println("Let's start the game!");
    }

    public void numberOfPlayers(){
        System.out.println("Set number of players: ");
    }

    public void enterPlayerName(int numberOfPlayers){
        System.out.println("Enter name of player " + numberOfPlayers);
    }

    public void numberOfDice(){
        System.out.println("Set number of dies to throw: ");
    }

    public void numberOfRounds(){
        System.out.println("Set number of rounds to play: ");
    }

    public void diceLoop(Player player, Dice dice){
        System.out.println(player.getName() + " rolls >>> " + player.getDiceRoll() + " <<< with dice >>> " + dice.getDiceCounter() + " <<<");
    }

    public void diceLoopDraw(Player player){
        System.out.println(player.getName() + " rolls >>> " + player.getDrawScore());
    }

    public void showResult(Player player){
        System.out.println("The results from this round is: " + ">>> Score <<<" + player.getName() + ": " + player.getScore() + " points. \n"); // MAKE """ TEXT BLOCK """
    }

    public void theWinnerIs(String name, int score){
        System.out.printf("""
                THE WINNER IS
                >>> %s <<<
                                
                with a total of
                >>> %d <<<
                                
                """,name, score );
    }

    public void welcomeToDraw(){

        System.out.println("WE HAVE A DRAW \n");
    }

    public void playAnotherRound(){

        System.out.println("""
                    Play another round?
                 
                    >>> Y/N <<<
                    Y to Continue
                    N to exit the application.
                    
                    """);
    }
}
