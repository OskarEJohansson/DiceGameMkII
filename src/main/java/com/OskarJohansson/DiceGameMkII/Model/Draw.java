package com.OskarJohansson.DiceGameMkII.Model;

import java.util.ArrayList;

public class Draw {

    int draw;
    int drawWinnerScore;
    int showDrawWinner;
    Player drawWinnerObject;
    ArrayList<Player> drawPlayerList;

    public Draw() {
        this.draw = 0;
        this.drawWinnerScore = 0;
        this.drawWinnerObject = new Player();
        this.drawPlayerList = new ArrayList<>();
        this.showDrawWinner = 0;
    }

    public int getDraw() {
        return draw;
    }

    public void setDraw(int isDraw) {
        this.draw = isDraw;
    }

    public ArrayList<Player> getDrawPlayerList() {
        return drawPlayerList;
    }

    public void resetDrawPlayerList() {
        this.drawPlayerList = new ArrayList<>();
    }

    public void addToDrawPlayerList(ArrayList uniquePlayersToDraw) {
        this.drawPlayerList = uniquePlayersToDraw;
    }

    public int getDrawWinnerScore() {
        return drawWinnerScore;
    }

    public void setDrawWinnerScore(int drawWinnerScore) {
        this.drawWinnerScore = drawWinnerScore;
    }

    public Player getDrawWinnerObject() {
        return drawWinnerObject;
    }
    public void setDrawWinnerObject(Player drawWinnerObject) {
        this.drawWinnerObject = drawWinnerObject;
    }

    public void resetDrawWinnerObject() {
        this.drawWinnerObject = new Player();
    }

    public int getShowDrawWinner() {
        return showDrawWinner;
    }

    public void setShowDrawWinner(int showDrawWinner) {
        this.showDrawWinner = showDrawWinner;
    }
}
