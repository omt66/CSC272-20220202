package edu.nu.csc272.week4.concurrency;

import java.security.SecureRandom;
import java.util.Date;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * PrintTask will simulate a printing task for us.
 * 
 * @author omt
 */
public class PrintTask implements Runnable {
    static private SecureRandom rng = new SecureRandom();
    private String taskName;
    private long sleepTime;
    
    public PrintTask(String name) {
        taskName = name;
        sleepTime = 1000 + rng.nextInt(10_000);
        System.out.println("PrintTaks " + name + " will do it's job in " + sleepTime + "ms");
    }

    @Override
    public void run() {
        System.out.println("Running " + taskName);
        try {
            // This is just simulating the print job for us!
            Thread.sleep(sleepTime);            
        } catch (InterruptedException ex) {
            System.err.println("Opps, something happened: " + ex.getMessage());
        }
        System.out.println(taskName + " is finished now " + new Date());
    }
}
