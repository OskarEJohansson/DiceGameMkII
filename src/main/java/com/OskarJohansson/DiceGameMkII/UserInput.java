package com.OskarJohansson.DiceGameMkII;

import java.util.Scanner;

public class UserInput {

    Scanner sc = new Scanner(System.in);


    public int inputInt() {

        while (!sc.hasNextInt()) {
            System.out.println("That's not a number!");
            sc.next();
        }
        return sc.nextInt();
    }

    public String inputString(){
        return sc.nextLine();
    }
}
