package Pr9.Google;


import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private Company company;
    private Car car;
    private List<Pokemon> pokemons;
    private List<Parent> parents;
    private List<Child> children;

    public Person(String name) {
        this.name = name;
        this.company = new Company("", "", 0);
        this.car = new Car("", 0);
        this.pokemons = new ArrayList<Pokemon>();
        this.parents = new ArrayList<Parent>();
        this.children = new ArrayList<Child>();
    }

    public String getName() {
        return this.name;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public List<Pokemon> getPokemons() {
        return this.pokemons;
    }

    public void setPokemons(List<Pokemon> pokemons) {
        this.pokemons = pokemons;
    }

    public List<Parent> getParents() {
        return this.parents;
    }

    public void setParents(List<Parent> parents) {
        this.parents = parents;
    }

    public List<Child> getChildren() {
        return this.children;
    }

    public void setChildren(List<Child> children) {
        this.children = children;
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("%s%n", this.name));
        builder.append(String.format("Company:%n"));
        if (!this.company.getName().equals("")) {
            builder.append(String.format("%s %s %.2f%n", this.company.getName(), this.company.getDepartment(), this.company.getSalary()));
        }
        builder.append(String.format("Car:%n"));
        if (!this.car.getModel().equals("")) {
            builder.append(String.format("%s %d%n", this.car.getModel(), this.car.getSpeed()));
        }
        builder.append(String.format("Pokemon:%n"));
        for (Pokemon pokemon : pokemons) {
            builder.append(String.format("%s %s%n", pokemon.getName(), pokemon.getType()));
        }
        builder.append(String.format("Parents:%n"));
        for (Parent parent : parents) {
            builder.append(String.format("%s %s%n", parent.getName(), parent.getDateOfBirth()));
        }
        builder.append(String.format("Children:%n"));
        for (Child child : children) {
            builder.append(String.format("%s %s%n", child.getName(), child.getDateOfBirth()));
        }
        return builder.toString();
    }
}
