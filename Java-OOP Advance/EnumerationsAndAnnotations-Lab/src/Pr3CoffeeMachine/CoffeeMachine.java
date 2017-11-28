package Pr3CoffeeMachine;

import java.util.ArrayList;
import java.util.List;

public class CoffeeMachine {
    private List<Coffee> coffees;
    private List<Coin> coins;

    public CoffeeMachine() {
        this.coffees = new ArrayList<>();
        this.coins = new ArrayList<>();
    }

    public void buyCoffee(String size, String type) {
        CoffeeType coffeeType = CoffeeType.valueOf(type.toUpperCase());
        CoffeeSize coffeeSize = CoffeeSize.valueOf(size.toUpperCase());
        Coffee coffee = new Coffee(coffeeType, coffeeSize);
        int sum = this.coins.stream().mapToInt(Coin::getCoin).sum();
        if (sum >= coffee.getCoffeeSize().getPrice()) {
            this.coffees.add(coffee);
            this.coins.clear();
        }
    }
    public void insertCoin(String coin) {
        Coin tempCoin = Coin.valueOf(coin.toUpperCase());
        this.coins.add(tempCoin);
    }
    public Iterable<Coffee> coffeesSold() {
        return this.coffees;
    }
}
