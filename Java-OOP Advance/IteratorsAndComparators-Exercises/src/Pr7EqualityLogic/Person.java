package Pr7EqualityLogic;

public class Person implements Comparable<Person>{

    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public int hashCode() {
        return this.name.hashCode() * this.age;
    }

    @Override
    public boolean equals(Object object) {
        if (object == null) {
            return false;
        }
        if (!(object instanceof Person)) {
            return false;
        }
        Person other = (Person) object;
        return this.getName().equals(other.getName()) && this.getAge() == other.getAge();
    }

    @Override
    public int compareTo(Person p) {
        return Integer.compare(this.hashCode(), p.hashCode());
    }

    @Override
    public String toString() {
        return String.format("%s %d", this.getName(), this.getAge());
    }
}
