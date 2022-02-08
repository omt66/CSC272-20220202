package edu.nu.csc272.week2.wordlegame;

import java.io.IOException;

/**
 *
 * @author omt
 */
public class WorldeApp {
    public static void main(String[] args) {
        System.out.println("--- Our Own Java Wordle Game (7 Feb 2022/Mon) ---");
        try {
            WordleGame game = new WordleGame(5);
            game.start();
        }
        catch (IOException ex) {
            System.out.println("Opps, file cannot be found! " + ex.getMessage());
        }
    }
}
