package edu.nu.csc272.week4.sort;

import java.security.SecureRandom;
import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author omt
 */
public class SortDemo {
    public static void main(String[] args) {
        System.out.println("--- Sort Demo ---");
        demo1();
    }
    
    static void demo1() {
        System.out.println("Demo1");
        //SecureRandom rng = new SecureRandom();
        Random rng = new Random();
        int maxElements = 10_000_000;
        int[] arr1 = rng.ints(maxElements).toArray();
        int[] arr2 = arr1.clone();
                
        Instant start = Instant.now();
        System.out.println("Started at " + start);
        // Sort the arr1
        Arrays.sort(arr1);
        System.out.println("After sort");
        Instant end = Instant.now();
        
        long diff = Duration.between(start, end).toMillis();
        System.out.println("Array1 took " + diff + " ms to sort");
        
        // Let's do parallel sorting here...
        start = Instant.now();
        Arrays.parallelSort(arr2);
        end = Instant.now();
        diff = Duration.between(start, end).toMillis();
        System.out.println("Array2 took " + diff + " ms to sort");
        
        for (int i=0;i < 10;i++) {
            System.out.println("arr1[" + i + "] = " + arr1[i]);
            System.out.println("arr2[" + i + "] = " + arr2[i]);
        }
    }
    
    static void printArr(int[] arr) {
        for (int i=0;i < arr.length;i++) {
            System.out.println(" arr[" + i + "] = " + arr[i]);
        }
    }
}
