package edu.nu.csc272.week4.midtermanswers;

/**
 *
 * @author omt
 */
public class MidtermAnswers {
    public static void main(String[] args) {
        System.out.println("--- Midterm Answers ---");
        // demo0();
        demo1();
    }
    
    static void demo0() {
        System.out.println("Modulus operation");
        int a, b, c;
        
        a = 11;
        b = 2;
        c = a%b;
        System.out.println("a, b & c=a%b -> " + a + ", " + b + ", " + c);
        
        a = 15;
        b = 12;
        c = a%b;
        System.out.println("a, b & c=a%b -> " + a + ", " + b + ", " + c);
        
        a = 420;
        b = 360;
        c = a%b;
        System.out.println("a, b & c=a%b -> " + a + ", " + b + ", " + c);
    }
    
    static void demo1() {
        System.out.println("Demo1");
        String sentence = "learing javafx is fun! javafx is a powerful library.";
        String result = capitalizeAndInvertInput(sentence);
        
        System.out.println("Sentence: " + sentence);
        System.out.println("Result: " + result);        
    }
    
    /**
     * This simple method will take an input sentence and capitalize the
     * first character, and later reverse the odd words.
     * Final sentence will be the concatenation of the individual words.
     * 
     * @param sentence Input sentence 
     * @return Capitalized and reversed words in the sentence
     */
    static String capitalizeAndInvertInput(String sentence) {
        String[] words = sentence.split(" ");
        StringBuilder mainBuilder = new StringBuilder();
        
        for (int i=0;i < words.length;i++) {
            String word = words[i];
            String firstCharStr = String.valueOf(word.charAt(0));
            String rest = word.substring(1);
            String newWord = firstCharStr.toUpperCase() + rest;
            
            if (i%2 != 0) {
                String[] chars = newWord.split("");
                StringBuilder sb = new StringBuilder(newWord);
                newWord = sb.reverse().toString();
            }
            mainBuilder.append(String.format("%s ", newWord));
        }
        
        return mainBuilder.toString();
    }
}
