package Pr2MultipleImplementation;

import Pr2MultipleImplementation.interfaces.Birthable;
import Pr2MultipleImplementation.interfaces.Identifiable;
import Pr2MultipleImplementation.interfaces.Person;

public class Citizen implements Person, Identifiable, Birthable{

    private String name;
    private Integer age;
    private String id;
    private String birthDate;

    Citizen(String name, Integer age, String id, String birthDate) {
        this.name = name;
        this.age = age;
        this.id = id;
        this.birthDate = birthDate;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Integer getAge() {
        return this.age;
    }

    @Override
    public String getBirthdate() {
        return this.birthDate;
    }

    @Override
    public String getId() {
        return this.id;
    }
}
