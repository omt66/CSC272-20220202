package edu.nu.csc272.week2.collections;

/**
 *
 * @author omt
 */
public class Person {
    String name;
    int age;
    
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Name: " + name + " age: " + age;
    }
}
