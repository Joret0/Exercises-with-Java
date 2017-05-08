package Pr7.CarSalesman;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Engine> engines = new ArrayList<>();
        List<Car> cars = new ArrayList<>();

        Integer n = Integer.parseInt(reader.readLine());

        for (int i = 0; i < n; i++) {
            String[] input = reader.readLine().split("\\s+");
            String model = input[0];
            int power = Integer.parseInt(input[1]);
            String displacement = null;
            String efficiency = null;
            if (input.length == 3) {
                char[] value = input[2].toCharArray();
                if (Character.isDigit(value[0])) {
                    displacement = input[2];
                } else {
                    efficiency = input[2];
                }
            } else if (input.length == 4) {
                displacement = input[2];
                efficiency = input[3];
            }
            Engine engine = new Engine(model, power, displacement, efficiency);
            engines.add(engine);
        }

        int m = Integer.parseInt(reader.readLine());

        for (int i = 0; i < m; i++) {
            String[] input = reader.readLine().split("\\s+");
            String model = input[0];
            String engineModel = input[1];
            String weight = null;
            String color = null;
            if (input.length == 3) {
                char[] value = input[2].toCharArray();
                if (Character.isDigit(value[0])) {
                    weight = input[2];
                } else {
                    color = input[2];
                }
            } else if (input.length == 4) {
                weight = input[2];
                color = input[3];
            }
            for (Engine engine : engines) {
                if (engineModel.equals(engine.getModel())) {
                    Car car = new Car(model, engine, weight, color);
                    cars.add(car);
                    break;
                }
            }
        }

        cars.stream().forEach(System.out::println);
    }
}
