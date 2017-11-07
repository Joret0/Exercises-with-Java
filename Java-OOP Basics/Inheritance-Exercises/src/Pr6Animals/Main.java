package Pr6Animals;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String animalType;
        while (true) {
            animalType = reader.readLine();
            if (animalType.trim().equals("") || animalType.equals("Beast!")) {
                break;
            }
            try {
                String[] animalData = reader.readLine().split("\\s+");
                if (!animalType.toLowerCase().equals("cat") &&
                        !animalType.toLowerCase().equals("dog") &&
                        !animalType.toLowerCase().equals("frog") &&
                        !animalType.toLowerCase().equals("kitten") &&
                        !animalType.toLowerCase().equals("tomcat") &&
                        !animalType.toLowerCase().equals("animal")) {
                    throw new IllegalArgumentException("Invalid input!");
                }
                String animalName;
                String animalAge;
                String animalGender;
                Animal animal = null;

                if (animalType.toLowerCase().equals("kitten") || animalType.toLowerCase().equals("tomcat")) {
                    if (animalData.length < 2) {
                        throw new IllegalArgumentException("Invalid input!");
                    }
                    animalName = animalData[0];
                    animalAge = animalData[1];
                    if (animalType.toLowerCase().equals("kitten")) {
                        animalGender = "Female";
                        animal = new Kitten(animalName, animalAge, animalGender);
                    } else {
                        animalGender = "Male";
                        animal = new Tomcat(animalName, animalAge, animalGender);
                    }
                } else {
                    if (animalData.length < 3) {
                        throw new IllegalArgumentException("Invalid input!");
                    }
                    animalName = animalData[0];
                    animalAge = animalData[1];
                    animalGender = animalData[2];

                    switch (animalType.toLowerCase()) {
                        case "cat":
                            animal = new Cat(animalName, animalAge, animalGender);
                            break;
                        case "dog":
                            animal = new Dog(animalName, animalAge, animalGender);
                            break;
                        case "frog":
                            animal = new Frog(animalName, animalAge, animalGender);
                            break;
                        case "animal":
                            animal = new Animal(animalName, animalAge, animalGender);
                            break;
                    }
                }
                if (animal != null) {
                    System.out.println(animal);
                }
            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}
