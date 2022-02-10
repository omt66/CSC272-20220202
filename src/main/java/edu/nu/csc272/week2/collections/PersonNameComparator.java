package edu.nu.csc272.week2.collections;

import java.util.Comparator;

/**
 *
 * @author omt
 */
public class PersonNameComparator implements Comparator<Person> {

    @Override
    public int compare(Person person1, Person person2) {
        return person1.name.compareTo(person2.name);
    }
}
