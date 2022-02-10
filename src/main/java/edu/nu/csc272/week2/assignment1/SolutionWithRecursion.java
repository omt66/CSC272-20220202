package edu.nu.csc272.week2.assignment1;

/**
 *
 * @author omt
 */
public class SolutionWithRecursion {
    public static void main(String[] args) {
        System.out.println("--- HW1 Solution Using Recursion ---");
        //findWords("2345678");

        // 23 ->
        //  AD, AE, AF
        //  BD, BE, BF
        //  CD, CE, CF
        findWords("23");
        
        findWords("2345678");
        
        String phoneWord, phoneNo;
        
        phoneWord = "PETCARE";
        phoneNo = findPhoneNumber(phoneWord);
        System.out.println("Phone number for " + phoneWord + " is " + phoneNo);

        phoneWord = "NEWCARS";
        phoneNo = findPhoneNumber(phoneWord);
        System.out.println("Phone number for " + phoneWord + " is " + phoneNo);
        
        phoneWord = "HAIRCUT";
        phoneNo = findPhoneNumber(phoneWord);
        System.out.println("Phone number for " + phoneWord + " is " + phoneNo);
    }
    static int phoneNoLength;
    
    static void findWords(String phoneNo) {
        System.out.println("Let's find the words for this phone # " + phoneNo);
        phoneNoLength = phoneNo.length();
        permutate("", phoneNo);
    }
    
    private static void permutate(String prefix, String numStr) {
        if (prefix.length() == phoneNoLength) {
            System.out.println(" word: " + prefix);
        }
        
        if (numStr.length() == 0) return;
        
        int n = Character.getNumericValue(numStr.charAt(0));
        String[] letters = getLettersFromNumber(n);
        numStr = numStr.substring(1);
        for (String letter: letters) {
            permutate(prefix + letter, numStr);
        }
    }
    
    static String[] getLettersFromNumber(int n) {
        String[] num2strMap = {
            "000",  // 0
            "111",  // 1
            "ABC",  // 2
            "DEF",  // 3
            "GHI",  // 4
            "JKL",  // 5
            "MNO",  // 6
            "PQRS", // 7
            "TUV",  // 8
            "WXYZ", // 9
        };
        String[] letters = num2strMap[n].split("");
        return letters;
    }

    /**
     * This is the reverse of the problem, i.e. we need to find the phone 
     * number, given that we have the word.
     * As you noticed this is much more simpler and straight forward solution.
     * 
     * @param word
     * @return phone number that corresponds to the word
     */
    static String findPhoneNumber(String word) {
        // PETCARE => [P, E, T, ...]
        String[] letters = word.split("");
        String phoneNumber = "";
        for (String letter: letters) {
            if ("ABC".contains(letter)) phoneNumber += "2";
            else if ("DEF".contains(letter)) phoneNumber += "3";
            else if ("GHI".contains(letter)) phoneNumber += "4";
            else if ("JKL".contains(letter)) phoneNumber += "5";
            else if ("MNO".contains(letter)) phoneNumber += "6";
            else if ("PQRS".contains(letter)) phoneNumber += "7";
            else if ("TUV".contains(letter)) phoneNumber += "8";            
            else if ("WXYZ".contains(letter)) phoneNumber += "9";            
            else phoneNumber += letter;
        }
        
        return phoneNumber;
    }
}
