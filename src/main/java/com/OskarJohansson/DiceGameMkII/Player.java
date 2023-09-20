package com.OskarJohansson.DiceGameMkII;

public class Player {

    public String name;
    private int result = 0;


    // Get Player Name
    public String getName() {
        return name;
    }

    // Set Player Name
    public void setName(String name) {
        this.name = name;
    }


    // Get Player Result
    public int getResult(){
        return result;
    }

    // Set Player result

    public void setResult(int result){
        this.result = result;
    }
}
