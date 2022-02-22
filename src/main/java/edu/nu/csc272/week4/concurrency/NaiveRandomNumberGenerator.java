package edu.nu.csc272.week4.concurrency;

import java.time.Instant;

/**
 * Simple  linear congruential generator.
 * https://en.wikipedia.org/wiki/Linear_congruential_generator
 * 
 * Xn+1 = (a*Xn + b) % m
 * @author omt
 */
public class NaiveRandomNumberGenerator {
    long x = 1;
    long a = 1664525;
    long b = 1013904223;
    long m = (long)Math.pow(2, 32); // 2^32
    
    public NaiveRandomNumberGenerator() { 
        x = Instant.now().toEpochMilli();
    }
    
    public NaiveRandomNumberGenerator(int seed) {
        this.x = seed;
    }
    
    private long getNextLong() {
        x = (a*x + b)%m;
        return x;
    }
    
    public double getNext() {
        double val = (double)getNextLong();
        double rnd = val/m;
        rnd = rnd >=0 && rnd < 1 ? rnd: 0;
        return rnd;
    }
    
    public int getNextInt(int min, int max) {
        return (int)(min + (max - min)*getNext());
    }
    
    public int getNextInt(int upperBound) {
        return getNextInt(0, upperBound);
    }
    
    public static void main(String[] args) {
        System.out.println("Testing naive random generator...");
        var rng = new NaiveRandomNumberGenerator(); 
        int max = 6;
        int[] vals = new int[max];
        
        for (int i=0;i < 5_000_000;i++) {
            int rndVal = rng.getNextInt(max);
            vals[rndVal]++;
        }
        
        System.out.println("Let's see the distribution...");
        int sum = 0;
        for (int i=0;i < max;i++) {
            int val = vals[i];
            sum += val;
            System.out.println("vals[" + i + "] = " + val);
        }
        System.out.println("Sum = " + sum);
        System.out.println("Avg = " + sum/max);
    }
}
