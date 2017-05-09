package Pr1.SortPersonsByNameAndAge;


public class Person {

    private String firstName;
    private String lastName;
    private Integer age;

    public Person(String firstName, String lastName, Integer age) {
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setAge(age);
    }

    public String getFirstName() {
        return this.firstName;
    }

    private void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    private void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return this.age;
    }

    private void setAge(Integer age) {
        this.age = age;
    }

    public String toString() {
        return String.format("%s %s is a %d years old.", this.getFirstName(), this.getLastName(), this.getAge());
    }
}
