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

    public void showDrawResults(Game game, GameTexts texts) {
        game.getPlayerList().stream().filter(Player::getDraw).forEach(texts::showDrawResult);
    }

    public void findWinner(Game game, ResetParameters resetParameters) {

        game.getPlayerList().forEach(player -> {

            if (player.getDraw()) {

                if (player.getDrawScore() > game.getDrawWinnerScore()) {

                    game.setDrawWinnerScore(player.getDrawScore());
                    game.setDrawWinnerObject(player);
                }

            } else {

                if (player.getScore() > game.getWinnerScore()) {

                    game.setWinnerScore(player.getScore());
                    game.setWinnerObject(player);
                }
            }
        });
    }

    public void findDraw(Game game, ResetParameters resetParameters) {

        game.getPlayerList().forEach(player -> {

            if (game.isDraw()) {

                game.setDraw(false);

                if (game.getDrawWinnerObject().getDrawScore() == player.getDrawScore() && game.getDrawWinnerObject().getName() != player.getName()) {
                    game.setDraw(true);
                    game.getDrawWinnerObject().setDraw(true);
                    player.setDraw(true);
                }

            } else if (game.getWinnerObject().getScore() == player.getScore() && game.getWinnerObject().getName() != player.getName()) {
                game.setDraw(true);
                game.getWinnerObject().setDraw(true);
                player.setDraw(true);
            }
        });
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

//    public void findWinner(Game game) {
//        for (Player player : game.getPlayerList()) {
//
//            while (game.isDraw()) {
//
//                if (player.getDrawScore() > game.getDrawWinnerScore()) {
//
//                    game.setDrawWinnerScore(player.getDrawScore());
//                    game.setDrawWinnerObject(player);
//                }
//            }
//            if (player.getScore() > game.getWinnerScore()) {
//
//                game.setWinnerScore(player.getScore());
//                game.setWinnerObject(player);
//            }
//        }
}

//    public void findDraw(Game game) {
//
//        for (Player player : game.getPlayerList()) {
//
//            while (player.getDraw()) {
//
//                if (player.getDrawScore() == game.getWinnerObject().getDrawScore() && !Objects.equals(player.getName(), game.getWinnerObject().getName())) {
//                    player.setDraw(true);
//                    game.setWinnerObject(player);
//                    game.setDraw(true);
//                }
//            }
//            if (player.getScore() == game.getWinnerObject().getScore() && !Objects.equals(player.getName(), game.getWinnerObject().getName())) {
//                player.setDraw(true);
//                game.getWinnerObject().setDraw(true); // LIGGER FELET HÄR?!
//                game.setDraw(true);
//            }
//        }
//    }

//}
