package edu.nu.csc272.week3;

/**
 *
 * @author omt
 */
public class GenericsDemo {
    public static void main(String[] args) {
        System.out.println("--- Generics Demos (15 Feb 2022/Tue) ---");
        // demo1();
        demo2();
    }
    
    static void demo1() {
        System.out.println("Demo1");
        Integer[] arrInt = {1, 2, 3, 4, 5, 6};
        Double[] arrDouble = {1.234, 2.5, 3.1, 4.4, 5.75};
        Character[] arrChar = {'a', 'b', 'c'};
        
        print("Integer array content:", arrInt);
        print("Double array content:", arrDouble);
        print("Character array content:", arrChar);
            
    }
    
    static void demo2() {
        System.out.println("Demo2");
        
        // Let's find the max value of the diffent items
        int maxVal = max(3, 1, 5);
        System.out.println("max value is " + maxVal);
        
//        double maxVal2 = max(3.5, 11.25, 5.2);
//        System.out.println("max value is " + maxVal);

        System.out.println("Max of 1, 5, 2 = " + maximum(1, 5, 2));
        System.out.println("Max of 34.5, 15.25, 22.0 = " + maximum(34.5, 15.25, 22.0));
        System.out.println("Max of pear, apple, orange = " + maximum("pear", "apple", "orange"));

    }
    
    static int max(int x, int y, int z) {
        int result = 0;
        
//        if (x > y) {
//            result = x;
//        }
//        else {
//            result = y;
//        }
//        
//        if (z > result) {
//            result = z;
//        }

        result = x > y ? x: y;
        result = z > result ? z: result;
        
        return result;
    }
    
    static <T extends Comparable<T>> T maximum(T x, T y, T z) {
        T result = x;
        
        if (y.compareTo(result) > 0){
            result = y;
        }
        
        if (z.compareTo(result) > 0) {
           result = z; 
        }
        
        return result;
    }
    
    static void printInt(String msg, Integer[] arr) {
        System.out.println(msg);
        for (Integer item: arr) {
            System.out.println(" * " + item);
        }
    }
    
    static void printDouble(String msg, Double[] arr) {
        System.out.println(msg);
        for (Double item: arr) {
            System.out.println(" * " + item);
        }
    }
    
    // Let's introduce generic method(s) here...
    
    /**
     * This is generic method to print out the contents of the array
     * 
     * @param <T> Generic type (could be anything like Integer, Double, etc.)
     * @param msg
     * @param arr 
     */
    static <T> void print(String msg, T[] arr) {
        System.out.println(msg);
        for (T item: arr) {
            System.out.println(" * " + item);
        }
    }
}
