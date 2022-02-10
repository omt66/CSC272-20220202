package edu.nu.csc272.week2.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author omt
 */
public class ListDemo {
    public static void main(String[] args) {
        System.out.println("--- List Demos (9 Feb 2022/Wed) ---");
        // demo1();
        demo2();
    }
    
    static void print(String msg, List<String> list) {
        System.out.println(msg);
        for (String item: list) {
            System.out.println(" * Item: " + item);
        }
    }
    
    static void print(String msgLine1, String msgLine2, List<Person> list) {
        System.out.println(msgLine1);
        System.out.println(msgLine2);
        for (Person item: list) {
            System.out.println(" * Item: " + item);
        }
    }
    
    static void demo1() {
        System.out.println("Demo1");
        String[] colors = {"color1", "color2", "color3", "color4"};
        List<String> list = new ArrayList<String>();
        
        // Add the colors to our list
        for (String color: colors) {
            list.add(color);
        }
        
        String[] colorsToRemove = {"color2"};
        List<String> listToRemove = new ArrayList<String>();

        // Add the removable colors to our removelist
        for (String color: colorsToRemove) {
            listToRemove.add(color);
        }
        
        print("List (before)", list);
        
        // Our intention to remove the colors from the first list
        removeItems(list, listToRemove);
        
        print("List (after)", list);
    }
    
    static void removeItems(List<String> list1, List<String> list2 ) {
        Iterator<String> iterator = list1.iterator();
        
        while (iterator.hasNext()) {
            String item = iterator.next();
            if (list2.contains(item)) {
                // Remove the current element that iterator points to
                iterator.remove(); 
            }
        }
    }
    
    static void demo2() {
        System.out.println("Demo2");
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        List<String> list = Arrays.asList(suits);
        
        print("Suits (before sort): ", list);
        Collections.sort(list);
        print("Suits (after sort): ", list);
        
        List<Person> people = new ArrayList<Person>();
        
        people.add(new Person("Jane Walker", 71));
        people.add(new Person("Adam Smith", 75));
        people.add(new Person("Jerry Seinfeld", 65));
        people.add(new Person("Eleine Benes", 55));
        
        //System.out.println("People (before sort) " + people);
        print("All people info:", "(before sort)", people);
        //Collections.sort(people, new PersonAgeComparator());
        Collections.sort(people, new PersonNameComparator());
        print("All people info:", "(after sort)", people);
    }
}
