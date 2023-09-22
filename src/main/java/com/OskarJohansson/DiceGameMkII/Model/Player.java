package com.OskarJohansson.DiceGameMkII.Model;

import com.OskarJohansson.DiceGameMkII.Control.UserInput;

public class Player {

    private String name;
    private int score = 0;
    private int drawScore = 0;
    private int diceRoll = 0;
    private int roundWin = 0;
    private boolean draw = false;

    UserInput scanner = new UserInput();

    // Get Player Name
    public String getName() {
        return name;
    }

    // Set Player Name
    public void setName(String name) {
        this.name = name;
    }

    // Get Player Result
    public int getScore() {
        return score;
    }

    public void setScore() {
        this.score += this.diceRoll;
    }

    public void resetScore() {
        this.score = 0;
    }

    public int getDrawScore() {
        return drawScore;
    }

    public void setDrawScore(int drawScore) {
        this.drawScore = drawScore;
    }

    public void resetDrawScore() {
        this.drawScore = 0;
    }

    public int setDiceRoll(int diceRoll) {
        this.diceRoll = diceRoll;
        return diceRoll;
    }

    public int getRoundWin() {
        return roundWin;
    }

    public void setRoundWin() {
        this.roundWin++;
    }

    public void resetRoundWin() {
        this.roundWin = 0;
    }

    public boolean getDraw() {
        return draw;
    }

    public void setDraw(boolean draw) {
        this.draw = draw;
    }

    public void resetDraw() {
        this.draw = false;
    }

}




