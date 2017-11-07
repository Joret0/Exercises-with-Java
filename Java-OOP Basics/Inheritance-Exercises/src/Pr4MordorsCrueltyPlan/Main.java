package Pr4MordorsCrueltyPlan;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().split("\\s+");
        List<Food> foodList = new ArrayList<>();
        for (String name : input) {
            Food food = new Food(name.toLowerCase());
            foodList.add(food);
        }
        Gandalf gandalf = new Gandalf(foodList, 0, "");
        System.out.println(gandalf);
    }
}
