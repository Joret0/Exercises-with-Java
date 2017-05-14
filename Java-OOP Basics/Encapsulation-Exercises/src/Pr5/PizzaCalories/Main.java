package Pr5.PizzaCalories;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            List<Pizza> pizzaList = new ArrayList<>();
            String input = reader.readLine();
            String[] info = input.split("\\s+");
            String command = info[0];
            if (command.equals("Pizza")) {
                while (!input.equals("END")) {
                    String[] inputData = input.split("\\s+");
                    command = inputData[0];
                    if (command.equals("Pizza")) {
                        String name = inputData[1];
                        int numberOfToppings = Integer.parseInt(inputData[2]);
                        Pizza pizza = new Pizza(name, numberOfToppings);
                        pizzaList.add(pizza);
                    } else {
                        if (command.equals("Dough")) {
                            String doughType = inputData[1];
                            String backingTechnique = inputData[2];
                            double grams = Double.parseDouble(inputData[3]);
                            Dough dough = new Dough(doughType, backingTechnique, grams);
                            for (Pizza pizza : pizzaList) {
                                pizza.setDough(dough);
                            }
                        } else if (command.equals("Topping")) {
                            String toppingType = inputData[1];
                            double grams = Double.parseDouble(inputData[2]);
                            Topping topping = new Topping(toppingType, grams);
                            for (Pizza pizza : pizzaList) {
                                pizza.addTopping(topping);
                            }
                        }
                    }
                    input = reader.readLine();
                }
            } else {
                while (!input.equals("END")) {
                    String[] inputData = input.split("\\s+");
                    command = inputData[0];
                    if (command.equals("Dough")) {
                        String doughType = inputData[1];
                        String backingTechnique = inputData[2];
                        double grams = Double.parseDouble(inputData[3]);
                        Dough dough = new Dough(doughType, backingTechnique, grams);
                        System.out.printf("%.2f%n", dough.getCalories());
                    } else if (command.equals("Topping")) {
                        String toppingType = inputData[1];
                        double grams = Double.parseDouble(inputData[2]);
                        Topping topping = new Topping(toppingType, grams);
                        System.out.printf("%.2f%n", topping.getCalories());
                    }
                    input = reader.readLine();
                }
            }
            for (Pizza pizza : pizzaList) {
                pizza.calculateCalories();
                System.out.println(pizza);
            }
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
