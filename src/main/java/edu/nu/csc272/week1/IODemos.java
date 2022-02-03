package edu.nu.csc272.week1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Misc IO demos
 * @author omt
 */
public class IODemos {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        System.out.println("--- I/O Demos (2 Feb 2022/Wed) ---");
//        demo1();
        demo2();
    }
    
    static void printFileInfo(File file) {
        System.out.println("File info:");
        System.out.println("  Name: " + file.getName());
        System.out.println("  Size (length): " + file.length());
        System.out.println("  Path: " + file.getPath());
    }
    
    static void demo1() throws FileNotFoundException, IOException {
        System.out.println("I/O Demo1");
        // Let's read a file from file system
        String fileName = "c:\\otmp\\hello.txt";
        
        System.out.println("Read file content of " + fileName);
        File file = new File(fileName);
        printFileInfo(file);
        System.out.println("\n");
        try (FileInputStream fis = new FileInputStream(file)) {
            byte[] dataBuffer = new byte[(int)file.length()];
            fis.read(dataBuffer);
            
            String content = new String(dataBuffer);
            System.out.println("File content:\n" + content);
        }
    }
    
    /**
     * This is probably the simplest text file read demo...
     */
    static void demo2() {
        System.out.println("I/O Demo2");
        String fileName = "c:\\otmp\\hello.txt";
        try {
            Path path = Paths.get(fileName);
            String content = Files.readString(path);
            System.out.println("Content:\n" + content);
        }
        catch (IOException ex) {
            System.out.println("Opps. File cannot be found " + ex.getMessage()); 
        }
    }
}
