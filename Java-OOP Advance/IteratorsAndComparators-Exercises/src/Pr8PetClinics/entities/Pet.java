package Pr8PetClinics.entities;

public class Pet {
    private String name;
    private int age;
    private String kind;

    public Pet(String name, int age, String kind) {
        this.name = name;
        this.age = age;
        this.kind = kind;
    }

    //GETTERS
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return this.name + " " + this.age + " " + this.kind;
    }
}
