import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Pr12VehiclePark {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        List<String> vehicleList = Arrays.stream(bufferedReader.readLine().split("\\s+")).collect(Collectors.toList());
        int total = vehicleList.size();
        String input = bufferedReader.readLine();
        boolean vehicleNotFound = true;
        while (!input.equals("End of customers!")) {
            String[] infoVehicle = input.split("\\s+");
            String vehicleType = infoVehicle[0].toLowerCase();
            int seats = Integer.parseInt(infoVehicle[2]);
            if (vehicleType.equals("car")) {
                for (int i = 0; i < vehicleList.size(); i++) {
                    String vehicle = vehicleList.get(i).charAt(0) + "";
                    if (vehicle.equals("c")) {
                        int vehicleSeats = Integer.parseInt(vehicleList.get(i).substring(1, vehicleList.get(i).length()));
                        if (seats == vehicleSeats) {
                            long amount = vehicleList.get(i).charAt(0) * vehicleSeats;
                            vehicleList.remove(i);
                            vehicleNotFound = false;
                            System.out.printf("Yes, sold for %d$%n", amount);
                            break;
                        }
                    }
                }
            } else if (vehicleType.equals("van")) {
                for (int i = 0; i < vehicleList.size(); i++) {
                    String vehicle = vehicleList.get(i).charAt(0) + "";
                    if (vehicle.equals("v")) {
                        int vehicleSeats = Integer.parseInt(vehicleList.get(i).substring(1, vehicleList.get(i).length()));
                        if (seats == vehicleSeats) {
                            long amount = vehicleList.get(i).charAt(0) * vehicleSeats;
                            vehicleList.remove(i);
                            vehicleNotFound = false;
                            System.out.printf("Yes, sold for %d$%n", amount);
                            break;
                        }
                    }
                }
            } else if (vehicleType.equals("bus")) {
                for (int i = 0; i < vehicleList.size(); i++) {
                    String vehicle = vehicleList.get(i).charAt(0) + "";
                    if (vehicle.equals("b")) {
                        int vehicleSeats = Integer.parseInt(vehicleList.get(i).substring(1, vehicleList.get(i).length()));
                        if (seats == vehicleSeats) {
                            long amount = vehicleList.get(i).charAt(0) * vehicleSeats;
                            vehicleList.remove(i);
                            vehicleNotFound = false;
                            System.out.printf("Yes, sold for %d$%n", amount);
                            break;
                        }
                    }
                }
            }
            if (vehicleNotFound) {
                System.out.println("No");
            }
            vehicleNotFound = true;
            input = bufferedReader.readLine();
        }

        String vehicleLeft = "Vehicles left: " + String.join(", ", vehicleList);
        System.out.println(vehicleLeft);
        String vehicleSold = "Vehicles sold: " + (total - vehicleList.size());
        System.out.println(vehicleSold);
    }
}