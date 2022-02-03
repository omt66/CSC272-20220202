package edu.nu.csc272.week1;

/**
 *
 * @author omt
 */
public class StringDemo {

    public static void main(String[] args) {
        String msg = "--- String Demos (2 Feb 2022/Wed) ---";
        System.out.println(msg);
//       demo1();
//       demo2();
//       demo3();
//       demo4();
//       demo5();
//       demo6();
        demo7();
    }

    static void demo1() {
        String str1 = "Hi there...";
        System.out.println("Length of the str1 = " + str1.length());
        int len = str1.length();

        System.out.println("Forward:");
        // Using old-school for loop
        for (int i = 0; i < len; i++) {
            char ch = str1.charAt(i);
            System.out.println("Char at position " + i + " -> " + ch);
        }

        System.out.println("Reversing the str1");

        for (int i = len - 1; i >= 0; i--) {
            char ch = str1.charAt(i);
            System.out.println("Char at position " + i + " -> " + ch);
        }

        // Let's create a char array
        int maxChars = 5;
        char[] chars = new char[maxChars];
        str1.getChars(0, maxChars, chars, 0);

        System.out.println("All the characters in the 'chars' variable");
        for (char ch : chars) {
            System.out.println("ch = " + ch);
        }

        String s1 = "hello";
        String s2 = "Hello";

        if (s1.equalsIgnoreCase(s2)) {
            System.out.println("s1 is equal to s2");
        } else {
            System.out.println("s1 is NOT equal to s2");
        }

        String key = "He";
        if (s1.startsWith(key)) {
            System.out.println("s1 starts with the key " + key);
        } else {
            System.out.println("s1 DOES NOT start with the key");
        }

        if (s2.startsWith(key)) {
            System.out.println("s2 starts with the key " + key);
        } else {
            System.out.println("s2 DOES NOT start with the key");
        }
    }

    static void demo2() {
        System.out.println("Demo2: indexOf");
        String longInfo = "After wild Divisional and Championship rounds, the upstart Cincinnati Bengals are set to meet the Los Angeles Rams on Feb. 13 for the NFL title. The game will take place at SoFi Stadium in Inglewood, California, which just so happens to be the Rams' home turf. This is the second consecutive year that the host city's team has made it to the Super Bowl -- the Tampa Bay Buccaneers won it at home last season. Will the Rams follow in their footsteps or will second-year phenom Joe Burrow lead the Bengals to the promised land? If the rest of the playoffs were any indication, this matchup looks like it could be an all-time classic. Some think that a game this exciting should have a TV that's up to the task.";
        String key1 = "Los Angeles";
        String key2 = "some other key";

        System.out.println(longInfo);
        int index = longInfo.indexOf(key1);
        System.out.println("key1 index = " + index);

        index = longInfo.indexOf(key2);
        System.out.println("key2 index = " + index);
    }

    static void demo3() {
        System.out.println("Demo3: String concat & upper and lower cases replace");
        String s1 = "Hello";
        String s2 = "World";
        String s3 = s1.concat(s2); // HelloWorld
        String s4 = s3.toLowerCase();
        String s5 = s3.toUpperCase();
        String s6 = s3.substring(0, 3).toLowerCase(); // hel
        String s7 = s3.substring(3).toUpperCase();    // LOWORLD
        String s8 = s6 + s7; // helLOWORLD
        String s9 = s8.replace("WORLD", "EARTH");

        System.out.println("s4 -> " + s4);
        System.out.println("s5 -> " + s5);
        System.out.println("s8 -> " + s8);
        System.out.println("s9 -> " + s9);
    }

    static void demo4() {
        System.out.println("Demo4: StringBuilder performance demo");
        String info;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 100_000; i++) {
            sb.append("new info " + i + "\n");
        }
        info = sb.toString();

        System.out.println("info -> " + info);
    }
    
    static String reverse(String str) {
        int len = str.length();
        StringBuilder sb = new StringBuilder();
        for (int i=len-1;i >= 0;i--) {
            sb.append(str.charAt(i));
        }
        return sb.toString();
    }
    
    static void demo5() {
        System.out.println("Demo5: StringBuilder other methods");
        StringBuilder sb = new StringBuilder();
        sb.append("Hi there, how are you doing?");
        String info1 = sb.toString();
        String info2 = sb.reverse().toString();
        String info3 = reverse(info1);
        String info4 = sb.delete(1, 5).toString();
                
        System.out.println("info1 -> " + info1);
        System.out.println("info2 -> " + info2);
        System.out.println("info3 -> " + info3);
        System.out.println("info4 -> " + info4);
    }
    
    static void demo6() {
        System.out.println("Demo6: Tokenization");
        String csvInfo = "1,2.5,4,5,6";
        String[] tokens = csvInfo.split(",");
        double[] numbers = new double[tokens.length];
        
        for (int i=0;i < tokens.length;i++) {
            String token = tokens[i];
            numbers[i] = Double.parseDouble(token);
        }
        
        double sum = 0;
        double avg;
        for (double n: numbers) {
            sum += n;
        }
        avg = sum / numbers.length;
        System.out.println("sum = " + sum + " avg: " + avg);
        
    }
    
    
    static boolean isValidName(String name) {
        boolean matched = name.matches("[A-Z][a-zA-Z]*");
        return matched;
    }
    
    static void demo7() {
        System.out.println("Demo7: RegEx demos");
        String name;
        
        // Check the name
        name = "JAne";
        boolean matched = isValidName(name);
        System.out.println("Valid name? " + matched);
    }
}
