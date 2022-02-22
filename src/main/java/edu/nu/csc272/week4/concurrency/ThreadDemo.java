package edu.nu.csc272.week4.concurrency;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Our thread demos will be here...
 * @author omt
 */
public class ThreadDemo {
    public static void main(String[] args) {
        System.out.println("--- Thread Demos ---");
        // demo1();
        demo2();
    }
    
    static ExecutorService executerService = Executors.newCachedThreadPool();
    
    static void demo1() {
        System.out.println("Demo1");
        
        PrintTask pt1 = new PrintTask("PrintTask1");
        PrintTask pt2 = new PrintTask("PrintTask2");
        PrintTask pt3 = new PrintTask("PrintTask3");
        
        executerService.execute(pt1);
        executerService.execute(pt2);
        executerService.execute(pt3);
        
        System.out.println("All tasks are started at " + new Date());
        executerService.shutdown();
    }
    
    static void demo2() {
        System.out.println("Demo2");
        int nofTasks = 1000;
        List<PrintTask> tasks = new ArrayList<>(); 
        
        for (int i=0;i < nofTasks;i++) {
            tasks.add(new PrintTask("PrintTask" + i));
        }
        
        System.out.println("Let's start the execution for the tasks...");
        
        tasks.forEach(task -> { 
          executerService.execute(task);
        });
        
        System.out.println("All tasks are started at " + new Date());
        executerService.shutdown();
    }
}
