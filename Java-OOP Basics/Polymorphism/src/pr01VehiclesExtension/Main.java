package pr01VehiclesExtension;

import pr01VehiclesExtension.exception.FuelException;
import pr01VehiclesExtension.vehicles.Bus;
import pr01VehiclesExtension.vehicles.Car;
import pr01VehiclesExtension.vehicles.Truck;
import pr01VehiclesExtension.vehicles.Vehicle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] vehicle1Data = reader.readLine().split("\\s+");
        String[] vehicle2Data = reader.readLine().split("\\s+");
        String[] vehicle3Data = reader.readLine().split("\\s+");

        Vehicle vehicle1 = createVehicle(vehicle1Data);
        Vehicle vehicle2 = createVehicle(vehicle2Data);
        Vehicle vehicle3 = createVehicle(vehicle3Data);

        Vehicle[] vehicles = new Vehicle[] {vehicle1, vehicle2, vehicle3};

        int n = Integer.valueOf(reader.readLine());

        for (int i = 0; i < n; i++) {
            String[] params = reader.readLine().split("\\s+");
            try {
                switch (params[0]) {
                    case "Drive":
                        tryToDrive(vehicles, false, params);
                        break;
                    case "DriveEmpty":
                        tryToDrive(vehicles, true, params);
                        break;
                    case "Refuel":
                        tryToRefuel(vehicles, params);
                        break;
                }
            } catch (FuelException fe) {
                System.out.println(fe.getMessage());
            }
        }
        for (Vehicle vehicle : vehicles) {
            System.out.println(vehicle);
        }
    }

    private static void tryToDrive(Vehicle[] vehicles, boolean isEmpty, String... params) {
        for (Vehicle vehicle : vehicles) {
            String vehicleName = vehicle.getClass().getSimpleName();
            if (vehicleName.equals(params[1])) {
                double xtraLtrs = 0;
                if (!isEmpty) {
                    xtraLtrs = Vehicle.extraLiters.get(vehicleName);
                }
                vehicle.drive(Double.valueOf(params[2]), xtraLtrs);
            }
        }
    }

    private static void tryToRefuel(Vehicle[] vehicles, String... params) {
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getClass().getSimpleName().equals(params[1])) {
                vehicle.refuel(Double.valueOf(params[2]));
            }
        }
    }

    private static Vehicle createVehicle(String... params) {
        Vehicle vehicle = null;
        Double fuelQuantity = Double.valueOf(params[1]);
        Double fuelConsumption = Double.valueOf(params[2]);
        Double tankCapacity = Double.valueOf(params[3]);
        switch (params[0]) {
            case "Car":
                vehicle = new Car(fuelQuantity, fuelConsumption, tankCapacity);
                break;
            case "Truck":
                vehicle = new Truck(fuelQuantity, fuelConsumption, tankCapacity);
                break;
            case "Bus":
                vehicle = new Bus(fuelQuantity, fuelConsumption, tankCapacity);
                break;
        }
        return vehicle;
    }
}
