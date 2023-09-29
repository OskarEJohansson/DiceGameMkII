package com.OskarJohansson.DiceGameMkII.Control.GameControl;

import com.OskarJohansson.DiceGameMkII.Model.Draw;
import com.OskarJohansson.DiceGameMkII.Model.Game;
import com.OskarJohansson.DiceGameMkII.Model.Player;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class ResetParameters {

    public void resetScoreInAllObjects(Game game) {
        game.getPlayerList().forEach(Player::resetScore) ;
    }
    public void resetDrawScoreInAllObjects(Draw draw) {
        draw.getDrawPlayerList().forEach(Player::resetDrawScore) ;
    }

    public void reserWinnerObjectInGame(Game game){
        game.resetWinnerObject();

    }

    public void resetDrawWinnerScoreInAllObjects(Game game) {
        game.getPlayerList().forEach(Player:: resetDrawScore);
    }


    public void resetRoundWin(Game game) {game.getPlayerList().forEach(Player::resetRoundWin);
    }
    public void resetAll(Game game) {
        resetScoreInAllObjects(game);
        resetDrawWinnerScoreInAllObjects(game);
        game.setWinnerScore(0);
        game.resetWinnerObject();
    }
}
