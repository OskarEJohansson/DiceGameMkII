package com.OskarJohansson.DiceGameMkII.Control.GameControl;

import com.OskarJohansson.DiceGameMkII.Control.GameTexts;
import com.OskarJohansson.DiceGameMkII.Model.Game;
import com.OskarJohansson.DiceGameMkII.Model.Player;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Objects;

public class GameResults {

    public void showResults(Game game, GameTexts texts) {
        game.getPlayerList().forEach(texts::showResult);
    }

    /*public void findWinner(@NotNull Game game) {

        for (Player player : game.getPlayerList()) {

            while (game.isDraw()) if (player.getDrawScore() > game.getDrawWinnerScore()) {

                game.setDrawWinnerScore(player.getDrawScore());
                game.setDrawWinnerObject(player);
            }

            if (player.getScore() > game.getWinnerScore()) {

                game.setWinnerScore(player.getScore());
                game.setWinnerObject(player);
            }
        }
    }

    public void findDraw(Game game) {

        for (Player player : game.getPlayerList()) {

            while (player.getDraw()) {

                if (player.getDrawScore() == game.getWinnerObject().getDrawScore() && !Objects.equals(player.getName(), game.getWinnerObject().getName())) {
                    player.setDraw(true);
                    game.getWinnerObject().setDraw(true);
                    game.setDraw(true);
                }
            }
            if (player.getScore() == game.getWinnerObject().getScore() && !Objects.equals(player.getName(), game.getWinnerObject().getName())) {
                player.setDraw(true);
                game.getWinnerObject().setDraw(true);
                game.setDraw(true);
            }
        }
    }*/

    public void findWinner(Game game) {
        for (Player player : game.getPlayerList()) {

            while (game.isDraw()) {

                if (player.getDrawScore() > game.getDrawWinnerScore()) {

                    game.setDrawWinnerScore(player.getDrawScore());
                    game.setDrawWinnerObject(player);
                }
            }
            if (player.getScore() > game.getWinnerScore()) {

                game.setWinnerScore(player.getScore());
                game.setWinnerObject(player);
            }
        }
    }

    public void findDraw(Game game) {

        for (Player player : game.getPlayerList()) {

            while (player.getDraw()) {

                if (player.getDrawScore() == game.getWinnerObject().getDrawScore() && !Objects.equals(player.getName(), game.getWinnerObject().getName())) {
                    player.setDraw(true);
                    game.setWinnerObject(player);
                    game.setDraw(true);
                }
            }
            if (player.getScore() == game.getWinnerObject().getScore() && !Objects.equals(player.getName(), game.getWinnerObject().getName())) {
                player.setDraw(true);
                game.getWinnerObject().setDraw(true);
                game.setDraw(true);
            }
        }
    }

}
