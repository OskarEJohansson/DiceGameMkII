package com.OskarJohansson.DiceGameMkII.Control;

import com.OskarJohansson.DiceGameMkII.Model.Player;
import com.sun.source.tree.AssertTree;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Before;

public class GameControlTest extends TestCase {

    private Player player;
    private GameControl gameControll;



    @Before
    public void setUp(){
        gameControll = new GameControl();

    }

    //A test to see if a player object is created with an AssertNotNull on return.
    public void testCreatePlayer() {
        player = gameControll.createPlayer("Oskar");
        assertNotNull(player);
    }

    // A test to see that the Naming of the player object is correct and that the function getName() in player model works.
    public void testCreatePlayerGetName() {

        player = gameControll.createPlayer("Oskar");
        String name = player.getName();
        Assert.assertEquals("Oskar", name);
    }


}