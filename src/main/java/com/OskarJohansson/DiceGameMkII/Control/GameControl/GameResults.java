package com.OskarJohansson.DiceGameMkII.Control.GameControl;

import com.OskarJohansson.DiceGameMkII.Control.GameTexts;
import com.OskarJohansson.DiceGameMkII.Model.Draw;
import com.OskarJohansson.DiceGameMkII.Model.Game;
import com.OskarJohansson.DiceGameMkII.Model.Player;

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

        game.getPlayerList().forEach(player -> {

            if (game.getWinnerScore() == player.getScore() && game.getWinnerObject().getName() != player.getName()) {
                draw.setDraw(1);
                draw.addToDrawPlayerList(game.getWinnerObject());
                draw.addToDrawPlayerList(player);
            }
        });
    }

    public void findWinnerInDraw(Draw draw) {

        draw.resetDrawWinnerObject();

        draw.getDrawPlayerList().forEach(player -> {

            if (player.getDrawScore() > draw.getDrawWinnerScore()) {

                draw.setDrawWinnerScore(player.getDrawScore());
                draw.setDrawWinnerObject(player);
                draw.setShowDrawWinner(1); // 1 == Show Draw winner
            }
        });
    }

    public void findDrawInDraw(Game game, Draw draw) {

        draw.setDraw(0);

        game.getPlayerList().forEach(player -> {

            draw.resetDrawPlayerList();

            if (draw.getDrawWinnerScore() == player.getDrawScore() && draw.getDrawWinnerObject().getName() != player.getName()) {
                draw.setDraw(1);
                draw.addToDrawPlayerList(draw.getDrawWinnerObject());
                draw.addToDrawPlayerList(player);
                draw.setShowDrawWinner(2); // 2 == Shows that we have another draw.
            } else {draw.setDraw(0);
            draw.resetDrawPlayerList();}
        });
    }
}
