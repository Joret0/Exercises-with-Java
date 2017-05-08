package Pr5.SpeedRacing;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        List<Car> cars = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] input = reader.readLine().split("\\s+");
            String model = input[0];
            double fuel = Double.parseDouble(input[1]);
            double cost = Double.parseDouble(input[2]);
            Car car = new Car(model, fuel, cost);
            cars.add(car);
        }

        String input = reader.readLine();
        while (!input.equals("End")) {
            String[] info = input.split("\\s+");
            String command = info[0];
            String model = info[1];
            int kms = Integer.parseInt(info[2]);
            if (command.equals("Drive")) {
                for (Car car : cars) {
                    if (model.equals(car.getModel())) {
                        car.drive(kms);
                    }
                }
            }

            input = reader.readLine();
        }

        cars.stream().forEach(System.out::println);
    }
}
