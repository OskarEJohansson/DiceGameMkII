package com.OskarJohansson.DiceGameMkII.Control.GameControl;

import com.OskarJohansson.DiceGameMkII.Control.GameTexts;
import com.OskarJohansson.DiceGameMkII.Model.Game;
import com.OskarJohansson.DiceGameMkII.Model.Player;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.IntStream;

public class CreatePlayer {
    public Player createPlayer(Player player, Scanner scanner) {
        player.setName(scanner.nextLine());
        return player;
    }

    public void namePlayers(Game game, GameTexts texts, Scanner scanner) {

        ArrayList<Player> playerList = game.getPlayerList();

        IntStream.range(0, game.getNumberOfPlayers()).forEach(i -> {
            texts.enterPlayerName(game.getCounter());
            Player player = new Player();
            playerList.add(createPlayer(player, scanner));
            game.addToCounter();
        });

        game.setPlayerList(playerList);
    }
}
