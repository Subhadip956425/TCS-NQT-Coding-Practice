package Hashing;

import java.util.HashSet;
import java.util.Objects;

class Person {
    private String name;
    private int age;

    // Constructor
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Overriding equals() to compare objects logically
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true; // same reference
        if (obj == null || getClass() != obj.getClass()) return false; // null or different class

        Person person = (Person) obj;
        return age == person.age && Objects.equals(name, person.name);
    }

    // Overriding hashCode() for consistency with equals()
    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public String toString() {
        return name + " (" + age + ")";
    }
}

public class Implements_HashCode {
    public static void main(String[] args) {
        Person p1 = new Person("Subhadip", 22);
        Person p2 = new Person("Subhadip", 22);
        Person p3 = new Person("Alex", 30);

        // Check logical equality
        System.out.println("p1.equals(p2): " + p1.equals(p2)); // true
        System.out.println("p1.equals(p3): " + p1.equals(p3)); // false

        // Add to HashSet (will avoid duplicates if equals & hashCode are correct)
        HashSet<Person> people = new HashSet<>();
        people.add(p1);
        people.add(p2);
        people.add(p3);

        System.out.println("HashSet content:");
        for (Person p : people) {
            System.out.println(p);
        }
    }
}