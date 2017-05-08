package Pr9.Google;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Person> personList = new ArrayList<>();
        String input = reader.readLine();
        while (!input.equals("End")) {
            String[] info = input.split("\\s+");
            String personName = info[0];
            Person person = new Person(personName);
            boolean personHasNotExist;
            String className = info[1];
            switch (className) {
                case "company":
                    String companyName = info[2];
                    String department = info[3];
                    double salary = Double.parseDouble(info[4]);
                    Company company = new Company(companyName, department, salary);
                    personHasNotExist = true;
                    for (Person person1 : personList) {
                        if (person1.getName().equals(personName)) {
                            person1.setCompany(company);
                            personHasNotExist = false;
                            break;
                        }
                    }
                    if (personHasNotExist) {
                        person.setCompany(company);
                        personList.add(person);
                    }
                    break;
                case "car":
                    String carName = info[2];
                    int speed = Integer.parseInt(info[3]);
                    Car car = new Car(carName, speed);
                    personHasNotExist = true;
                    for (Person person1 : personList) {
                        if (person1.getName().equals(personName)) {
                            person1.setCar(car);
                            personHasNotExist = false;
                            break;
                        }
                    }
                    if (personHasNotExist) {
                        person.setCar(car);
                        personList.add(person);
                    }
                    break;
                case "pokemon":
                    String pokemonName = info[2];
                    String type = info[3];
                    Pokemon pokemon = new Pokemon(pokemonName, type);
                    personHasNotExist = true;
                    for (Person person1 : personList) {
                        if (person1.getName().equals(personName)) {
                            person1.getPokemons().add(pokemon);
                            personHasNotExist = false;
                            break;
                        }
                    }
                    if (personHasNotExist) {
                        List<Pokemon> pokemons = new ArrayList<>();
                        pokemons.add(pokemon);
                        person.setPokemons(pokemons);
                        personList.add(person);
                    }
                    break;
                case "parents":
                    String parentName = info[2];
                    String dateOfBirth = info[3];
                    Parent parent = new Parent(parentName, dateOfBirth);
                    personHasNotExist = true;
                    for (Person person1 : personList) {
                        if (person1.getName().equals(personName)) {
                            person1.getParents().add(parent);
                            personHasNotExist = false;
                            break;
                        }
                    }
                    if (personHasNotExist) {
                        List<Parent> parents = new ArrayList<>();
                        parents.add(parent);
                        person.setParents(parents);
                        personList.add(person);
                    }
                    break;
                case "children":
                    String childName = info[2];
                    String childDateOfBirth = info[3];
                    Child child = new Child(childName, childDateOfBirth);
                    personHasNotExist = true;
                    for (Person person1 : personList) {
                        if (person1.getName().equals(personName)) {
                            person1.getChildren().add(child);
                            personHasNotExist = false;
                            break;
                        }
                    }
                    if (personHasNotExist) {
                        List<Child> children = new ArrayList<>();
                        children.add(child);
                        person.setChildren(children);
                        personList.add(person);
                    }
                    break;
            }
            input = reader.readLine();
        }
        String name = reader.readLine();
        for (Person person : personList) {
            if (person.getName().equals(name)) {
                System.out.print(person.toString());
                break;
            }
        }
    }
}
