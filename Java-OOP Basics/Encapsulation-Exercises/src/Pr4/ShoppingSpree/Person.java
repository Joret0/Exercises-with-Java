package Pr4.ShoppingSpree;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class Person {
    private String name;
    private double money;
    private List<Product> products;

    public Person(String name, double money) {
        this.setName(name);
        this.setMoney(money);
        this.setProducts(new ArrayList<>());
    }

    public String getName() {
        return this.name;
    }
    private void setName(String name) {
        if (name.isEmpty() || name.trim().length() == 0) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name;
    }
    private double getMoney() {
        return this.money;
    }
    private void setMoney(double money) {
        if (money < 0) {
            throw new IllegalArgumentException("Money cannot be negative");
        }
        this.money = money;
    }
    private List<Product> getProducts() {
        return this.products;
    }
    private void setProducts(List<Product> products) {
        this.products = products;
    }
    
    public void addProduct(Product product) {
        if (product.getCost() > this.getMoney()) {
            printCannotBuyMessage(product);
            return;
        }
        printBuyMessage(product);
        this.setMoney(this.getMoney() - product.getCost());
        this.getProducts().add(product);
    }

    private void printBuyMessage(Product product) {
        System.out.printf("%s bought %s%n", this.getName(), product.getName());
    }

    private void printCannotBuyMessage(Product product) {
        System.out.printf("%s can't afford %s%n", this.getName(), product.getName());
    }

    @Override
    public String toString() {
        return String.format("%s - %s", this.getName(),
                this.products.size() > 0 ?
        this.products.stream().map(String::valueOf).collect(Collectors.joining(", "))
        : "Nothing bought");
    }
}
