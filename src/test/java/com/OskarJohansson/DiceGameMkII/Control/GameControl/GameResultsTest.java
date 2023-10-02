package com.OskarJohansson.DiceGameMkII.Control.GameControl;

import com.OskarJohansson.DiceGameMkII.Model.Game;
import com.OskarJohansson.DiceGameMkII.Model.Player;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class GameResultsTest extends TestCase {

    Game game;
    GameResults gameResults;
    Player player;
    ArrayList<Player> playerlist;
    ResetParameters resetParameters;

    @Before
    public void setUp(){

        resetParameters = new ResetParameters();
        game = new Game();
        gameResults = new GameResults();
        player = new Player();
        playerlist = new ArrayList<Player>();

        player.setName("Oskar");
        player.setDrawScore(1);
        playerlist.add(player);
        player.setName("max");
        player.setDrawScore(1);
        playerlist.add(player);
        game.setPlayerList(playerlist);
    }

    public void testFindWinner() {


    }

}