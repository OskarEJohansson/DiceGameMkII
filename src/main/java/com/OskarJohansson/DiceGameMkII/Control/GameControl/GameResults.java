package com.OskarJohansson.DiceGameMkII.Control.GameControl;

import com.OskarJohansson.DiceGameMkII.Control.GameTexts;
import com.OskarJohansson.DiceGameMkII.Model.Draw;
import com.OskarJohansson.DiceGameMkII.Model.Game;
import com.OskarJohansson.DiceGameMkII.Model.Player;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GameResults {

    public void showResults(Game game, GameTexts texts) {
        game.getPlayerList().forEach(texts::showResultPlayer);
    }

    public void showDrawResultsPlayer(Draw draw, GameTexts texts) {
        draw.getDrawPlayerList().forEach(texts::showDrawResultPlayers);
    }

    public void findWinner(Game game) {

        game.getPlayerList().forEach(player -> {

            if (player.getScore() > game.getWinnerScore()) {
                game.setWinnerScore(player.getScore());
                game.setWinnerObject(player);
            }
        });
    }

    public void findDraw(Game game, Draw draw) {

        // Hashset to make sure only unique obejcts are saved to the draw player list
        Set<Player> uniquePlayersToDraw = new HashSet<>();

        uniquePlayersToDraw = findUniquePlayersToDraw(game, draw, uniquePlayersToDraw);

        if (!uniquePlayersToDraw.isEmpty()) {
            draw.setDraw(1);
            draw.setShowDrawWinner(1);
            ArrayList<Player> uniqueDrawPlayerList = new ArrayList<>(uniquePlayersToDraw);
            draw.addToDrawPlayerList(uniqueDrawPlayerList);
        }
    }

    public Set<Player> findUniquePlayersToDraw(Game game, Draw draw, Set<Player> uniquePlayersToDraw) {

        game.getPlayerList().forEach(player -> {

            if (game.getWinnerScore() == player.getScore() && game.getWinnerObject().getName() != player.getName()) {
                draw.setDraw(1);
                uniquePlayersToDraw.add(game.getWinnerObject());
                uniquePlayersToDraw.add(player);
            }
        });
        return uniquePlayersToDraw;
    }

    public void findWinnerInDraw(Draw draw) {

        //Reset draw winner score
        draw.setDrawWinnerScore(0);

        draw.getDrawPlayerList().forEach(player -> {

            if (player.getDrawScore() > draw.getDrawWinnerScore()) {

                draw.setDrawWinnerScore(player.getDrawScore());
                draw.setDrawWinnerObject(player);
                draw.setShowDrawWinner(1); // 1 == Show Draw winner
            }
        });
    }

    public void findDrawInDraw(Game game, Draw draw) {
        Set<Player> uniquePlayersToDraw = new HashSet<>();

        draw.setDraw(0);

        uniquePlayersToDraw = findUniquePlayersFromDrawToDraw(game, draw, uniquePlayersToDraw);

        if (!uniquePlayersToDraw.isEmpty()) {
            draw.setDraw(1);
            draw.setShowDrawWinner(1);
            // Creating a new unique ArrayList that Object Draw can recieve.
            ArrayList<Player> uniqueDrawPlayerList = new ArrayList<>(uniquePlayersToDraw);
            draw.addToDrawPlayerList(uniqueDrawPlayerList);

        } else {
            draw.setDraw(0);
            draw.resetDrawPlayerList();
        }
    }

    public Set<Player> findUniquePlayersFromDrawToDraw(Game game, Draw draw, Set<Player> uniquePlayersToDraw) {
        // Hashset to make sure only unique obejcts are saved to the draw player list

        game.getPlayerList().forEach(player -> {

            if (draw.getDrawWinnerScore() == player.getDrawScore() && draw.getDrawWinnerObject().getName() != player.getName()) {
                draw.setDraw(1);
                uniquePlayersToDraw.add(game.getWinnerObject());
                uniquePlayersToDraw.add(player);
                draw.setShowDrawWinner(2); // 2 == Shows that we have another draw.
            }

        });

        return uniquePlayersToDraw;

    }
}
