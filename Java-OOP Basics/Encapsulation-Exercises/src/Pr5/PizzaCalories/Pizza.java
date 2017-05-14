package Pr5.PizzaCalories;


import java.util.ArrayList;
import java.util.List;

public class Pizza {
    private String name;
    private Dough dough;
    private List<Topping> toppingList;
    private double calories;
    private int numberOfToppings;

    public Pizza(String name, int numberOfToppings) {
        this.setName(name);
        this.setNumberOfToppings(numberOfToppings);
        this.setToppingList(new ArrayList<>());
    }

    private String getName() {
        return this.name;
    }
    private void setName(String name) {
        if (name.isEmpty() && name.length() < 1 && name.length() > 15) {
            throw new IllegalArgumentException("Pizza name should be between 1 and 15 symbols.");
        }
        this.name = name;
    }
    private int getNumberOfToppings() {
        return this.numberOfToppings;
    }
    private void setNumberOfToppings(int numberOfToppings) {
        if (numberOfToppings < 0 || numberOfToppings > 10) {
            throw new IllegalArgumentException("Number of toppings should be in range [0..10].");
        }
        this.numberOfToppings = numberOfToppings;
    }

    private Dough getDough() {
        return this.dough;
    }
    public void setDough(Dough dough) {
        this.dough = dough;
    }
    public void addTopping(Topping topping) {
        this.toppingList.add(topping);
    }
    private List<Topping> getToppingList() {
        return this.toppingList;
    }
    private void setToppingList(List<Topping> toppingList) {
        this.toppingList = toppingList;
    }
    private double getCalories() {
        return this.calories;
    }
    private void setCalories(double calories) {
        this.calories = calories;
    }

    public void calculateCalories() {
        for (Topping topping : toppingList) {
            this.setCalories(this.getCalories() + topping.getCalories());
        }
        this.setCalories(this.getCalories() + this.dough.getCalories());
    }

    @Override
    public String toString() {
        return String.format("%s - %.2f", this.getName(), this.getCalories());
    }
}
