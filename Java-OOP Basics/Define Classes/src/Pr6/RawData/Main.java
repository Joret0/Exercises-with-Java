package Pr6.RawData;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        List<Car> carList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] input = reader.readLine().split("\\s+");
            String model = input[0];

            int engineSpeed = Integer.parseInt(input[1]);
            int enginePower = Integer.parseInt(input[2]);
            Engine engine = new Engine(engineSpeed, enginePower);

            int cargoWeight = Integer.parseInt(input[3]);
            String cargoType = input[4];
            Cargo cargo = new Cargo(cargoWeight, cargoType);

            double tire1Pressure = Double.parseDouble(input[5]);
            int tire1Age = Integer.parseInt(input[6]);
            Tire tire1 = new Tire(tire1Pressure, tire1Age);

            double tire2Pressure = Double.parseDouble(input[7]);
            int tire2Age = Integer.parseInt(input[8]);
            Tire tire2 = new Tire(tire2Pressure, tire2Age);

            double tire3Pressure = Double.parseDouble(input[9]);
            int tire3Age = Integer.parseInt(input[10]);
            Tire tire3 = new Tire(tire3Pressure, tire3Age);

            double tire4Pressure = Double.parseDouble(input[11]);
            int tire4Age = Integer.parseInt(input[12]);
            Tire tire4 = new Tire(tire4Pressure, tire4Age);

            List<Tire> tires = new ArrayList<>();
            tires.add(tire1);
            tires.add(tire2);
            tires.add(tire3);
            tires.add(tire4);

            Car car = new Car(model, engine, cargo, tires);
            carList.add(car);
        }

        String command = reader.readLine();

        switch (command) {
            case "fragile":
                for (Car car : carList) {
                    if (car.getCargo().getType().equals("fragile")) {
                        List<Tire> tires = car.getTires();
                        for (Tire tire : tires) {
                            if (tire.getPressure() < 1) {
                                System.out.printf("%s%n", car.getModel());
                                break;
                            }
                        }
                    }
                }
                break;
            case "flamable":
                for (Car car : carList) {
                    if (car.getCargo().getType().equals("flamable")) {
                        if (car.getEngine().getPower() > 250) {
                            System.out.printf("%s%n", car.getModel());
                        }
                    }
                }
                break;
        }
    }
}
