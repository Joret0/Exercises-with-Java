package pr03WildFarm.animals;

import pr03WildFarm.foods.Food;

/**
 * Created by User on 10.1.2017 г..
 */
public class Cat extends Felime {

    public String breed;

    public Cat(String animalName, double animalWeight, String livingRegion, String breed) {
        super(animalName, animalWeight, livingRegion);
        this.breed = breed;
    }

    public String getBreed() {
        return breed;
    }

    @Override
    public void makeSound() {
        System.out.println("Meowwww");
    }

    @Override
    public void eatFood(Food food) {
        this.consumeFood(food.getQuantity());
    }

    @Override
    public String toString() {

        return String.format("%s[%s, %s, %s, %s, %s]",
                this.getClass().getSimpleName(),
                this.getAnimalName(),
                this.getBreed(),
                format.format(this.getAnimalWeight()),
                this.getLivingRegion(),
                this.getFoodEaten());
    }
}
