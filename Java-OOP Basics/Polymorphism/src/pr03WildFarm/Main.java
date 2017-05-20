package pr03WildFarm;

import pr03WildFarm.animals.*;
import pr03WildFarm.exceptions.NotEatingException;
import pr03WildFarm.foods.Food;
import pr03WildFarm.foods.Meat;
import pr03WildFarm.foods.Vegetable;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while (!(line = reader.readLine()).equals("End")) {
            String[] params = line.split("\\s+");
            String[] foodParams = reader.readLine().split("\\s+");
            Food food = null;
            switch (foodParams[0]) {
                case "Vegetable":
                    food = new Vegetable(Integer.valueOf(foodParams[1]));
                    break;
                case "Meat":
                    food = new Meat(Integer.valueOf(foodParams[1]));
                    break;
            }
            feedAnimal(food, params);
        }
    }

    private static void feedAnimal(Food food, String... params) {
        String animalName = params[1];
        double animalWeight = Double.valueOf(params[2]);
        String livingRegion = params[3];
        Mammal mammal = null;
        if (params.length == 5) {
            String breed = params[4];
            mammal = new Cat(animalName, animalWeight, livingRegion, breed);
        } else {
            switch (params[0]) {
                case "Zebra":
                    mammal = new Zebra(animalName, animalWeight, livingRegion);
                    break;
                case "Mouse":
                    mammal = new Mouse(animalName, animalWeight, livingRegion);
                    break;
                case "Tiger":
                    mammal = new Tiger(animalName, animalWeight, livingRegion);
                    break;
            }
        }
        mammal.makeSound();
        try {
            mammal.eatFood(food);
        } catch (NotEatingException nee) {
            System.out.println(nee.getMessage());
        }
        System.out.println(mammal);
    }
}
