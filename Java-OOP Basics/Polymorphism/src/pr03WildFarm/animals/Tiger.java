package pr03WildFarm.animals;

import pr03WildFarm.exceptions.NotEatingException;
import pr03WildFarm.foods.Food;

/**
 * Created by User on 10.1.2017 г..
 */
public class Tiger extends Felime {

    public Tiger(String animalName, double animalWeight, String livingRegion) {
        super(animalName, animalWeight, livingRegion);
    }

    @Override
    public void makeSound() {
        System.out.println("ROAAR!!!");
    }

    @Override
    public void eatFood(Food food) {
        if (food.getClass().getSimpleName().equals("Vegetable")) {
            throw new NotEatingException("Tigers are not eating that type of food!");
        }
        this.consumeFood(food.getQuantity());
    }
}
