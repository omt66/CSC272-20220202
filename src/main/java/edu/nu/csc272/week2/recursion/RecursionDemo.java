package edu.nu.csc272.week2.recursion;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author omt
 */
public class RecursionDemo {
    public static void main(String[] args) {
        System.out.println("--- Recursion Demos ---");
        demo1();
    }
    
    static void demo1() {
        System.out.println("Demo1");
        //problematicMethod();
        long result;

        for (int n=1;n < 30;n++) {
            result = factorial(n);
            System.out.println("Result of " + n + "! = " + result);
        }
        
        System.out.println("Fibonacci numbers:");
        for (int n=0;n <= 47;n++) {
            result = fibo(n);
            System.out.println("Result of Fibonacci(" + n + ") = " + result);
        }
    }
    
    /**
     * This method finds the factorial of a number
     * n! = n*(n-1)* ... *1
     * 
     * @param n
     * @return factorial of the number n
     */
    static long factorial(int n) {
        if (n < 0) throw new RuntimeException("n must be positive!");
        
        if (n == 0 || n == 1) return 1;
        
        return n*factorial(n - 1);
    }
    
    // We will use this one for our lookup table for Fibonacci calculations
    static Map<Integer, Long> fiboMap = new HashMap<>();
    
    /**
     * Fibonacci number of n
     * F0 = 0
     * F1 = 1
     * Fn = Fn-1 + Fn-2
     * @param n
     * @return 
     */
    static long fibo(int n) {
        if (n < 0) return 0;
        if (n == 0) return 0;
        if (n == 1) return 1;
             
        if (fiboMap.containsKey(n)) {
            return fiboMap.get(n);
        }
        long result = fibo(n-1) + fibo(n-2);
        fiboMap.put(n, result);
        
        return result;
    }
    
    static void problematicMethod() {
        System.out.println("In the problematicMethod " + new Date());
        problematicMethod();
    }
}
