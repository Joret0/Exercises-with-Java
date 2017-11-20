package Pr6BirthdayCelebrations;


public class Citizen implements Inhabitable{

    private String name;
    private int age;
    private String id;
    private String year;

    public Citizen(String name, int age, String id, String year) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.year = year;
    }

    @Override
    public String getYear() {
        return this.year;
    }

    @Override
    public String getId() {
        return this.id;
    }
}
