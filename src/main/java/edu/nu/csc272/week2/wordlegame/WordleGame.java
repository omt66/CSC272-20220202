package edu.nu.csc272.week2.wordlegame;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author omt
 */
public class WordleGame {
    private int nofCharsInWord;
    private String[] words;
    private List<String> selectedWords = new ArrayList<String>();
    private String selectedWord;
    
    public WordleGame(int n) throws IOException {
        nofCharsInWord = n;
        loadWords();
    }
    
    private void loadWords() throws IOException {
        String fileName = "words.txt";
        Path path = Paths.get(fileName);
        String content = Files.readString(path);
        words = content.split("\n");
        
        for (String word: words) {
            if (word.length() == nofCharsInWord && !word.contains("-") && !word.contains("'")) {
                selectedWords.add(word);
            }
        }
                
        System.out.println("Total English words: " + words.length);
        System.out.println("Selected words: " + selectedWords.size());
    }
    
    public void start() {
        System.out.println("Wordle game starting now...");
        int size = selectedWords.size();
        int randNo = (int)(size*Math.random());
        selectedWord = selectedWords.get(randNo);
       
        // Don't show the selected word during actual game! :) 
        System.out.println("Selected word: " + selectedWord);
       
        boolean done = false;
        Scanner input = new Scanner(System.in);
        System.out.println("Guess a word, or type 'q' to quit!");
        
        while (!done) {
            System.out.println("Guess: ");
            String answer = input.nextLine();
            
            if (answer.equals("q")) {
                done = true;
                System.out.println("Hey, thanks for playing...");
            }
            else {
                boolean acceptable = isAcceptableWord(answer);
                
                // We need to check if the guess word is OK
                if (!acceptable) {
                    System.out.println(answer + " is NOT acceptable!");
                }
                else {
                    if (answer.equalsIgnoreCase(selectedWord)) {
                        System.out.println("BRAVO, you got it!");
                    }
                    else {
                        // Provide a feedback to the user!
                        String feedback = getFeedback(selectedWord, answer);
                        System.out.println(feedback);
                    }
                }
            }
        }
        
        input.close();
        System.out.println("Bye bye now.");
    }
    /**
     * If the letter in the word but in the incorrect position than we will add
     * "?" to it.
     * If in the correct position and correct then we will keep it as is
     * If the letter not in the word at all we will mark it with "!"
     * 
     * @param actual
     * @param guess
     * @return 
     */
    private String getFeedback(String actual, String guess) {
        int len = actual.length();
        String feedback = "";
        
        for (int i=0;i < len;i++) {
            char ch1 = actual.charAt(i);
            char ch2 = guess.charAt(i);
            
            feedback += ch2;
            
            if (ch1 == ch2) {
                // Correct letter and correct position
                // feedback += "";
            }
            else if (actual.indexOf(ch2) != -1) {
                feedback += "?";
            }
            else {
                feedback += "!";
            }
            
            feedback += " ";
        }
        
        return feedback;
    }
    
    /**
     * Checks if the guess word is acceptable or not!
     * Simply goes through the selected word list and verifies if it is a good 
     * word. 
     * 
     * @param word guess word
     * @return If it is good returns true, or else false
     */
    private boolean isAcceptableWord(String word) {
        if (word.length() != nofCharsInWord) {
            return false;
        }
            
        int size = selectedWords.size();
        
        // We need to check all the selected words to find out if it is OK!
        for (int i=0;i < size;i++) {
            if (selectedWords.get(i).equalsIgnoreCase(word)) {
                return true;
            }
        }
        
        return false;
    }
}
