package Pr5ComparingObjects;

public class Person implements Comparable<Person>{
    private String name;
    private int age;
    private String town;

    Person(String name, int age, String town) {
        this.name = name;
        this.age = age;
        this.town = town;
    }

    @Override
    public int compareTo(Person person) {
        if (this.name.compareTo(person.name) == 0) {
            return compareByAge(person);
        }
        return this.name.compareTo(person.name);
    }

    private int compareByAge(Person person) {
        if (this.age - person.age == 0) {
            return this.town.compareTo(person.town);
        }
        return this.age - person.age;
    }


}
