package Pr3CoffeeMachine;

public class Coffee {
    private CoffeeType coffeeType;
    private CoffeeSize coffeeSize;

    public Coffee(CoffeeType coffeeType, CoffeeSize coffeeSize) {
        this.coffeeType = coffeeType;
        this.coffeeSize = coffeeSize;
    }

    public CoffeeType getCoffeeType() {
        return this.coffeeType;
    }

    public CoffeeSize getCoffeeSize() {
        return this.coffeeSize;
    }

    @Override
    public String toString() {
        return String.format("%s %s", this.coffeeSize, this.coffeeType);
    }
}
