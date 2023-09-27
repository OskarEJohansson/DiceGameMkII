package com.OskarJohansson.DiceGameMkII.Control.GameControl;

import com.OskarJohansson.DiceGameMkII.Model.Game;
import com.OskarJohansson.DiceGameMkII.Model.Player;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class ResetParameters {

    public void resetScoreInAllObjects(Game game) {
        game.getPlayerList().forEach(Player::resetScore) ;
    }

    public void resetDrawWinnerScoreInAllObjects(Game game) {
        game.getPlayerList().forEach(Player:: resetDrawScore);
    }

    public void resetDrawInAllObjectsInAllObjects(Game game) {
        game.getPlayerList().forEach(Player::resetDraw);
    }

    public void resetAll(Game game) {
        resetScoreInAllObjects(game);
        resetDrawWinnerScoreInAllObjects(game);
        resetDrawInAllObjectsInAllObjects(game);
        game.setWinnerScore(0);
        game.resetDrawWinnerObject();
        game.resetWinnerObject();
    }

    public void resetRoundWin(@NotNull ArrayList<Player> playerList) {
        for (Player player : playerList) {
            player.resetRoundWin();
        }
    }

}
