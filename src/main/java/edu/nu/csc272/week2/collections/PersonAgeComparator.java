package edu.nu.csc272.week2.collections;

import java.util.Comparator;

/**
 *
 * @author omt
 */
public class PersonAgeComparator implements Comparator<Person> {

    @Override
    public int compare(Person person1, Person person2) {
//        if (person1.age == person2.age) return 0;        
//        if (person1.age < person2.age) return -1;
//        
//        return 1;
        return person1.age - person2.age;
    }
    
}
