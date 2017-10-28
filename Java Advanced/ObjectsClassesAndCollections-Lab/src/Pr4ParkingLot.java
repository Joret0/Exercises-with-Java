import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Pr4ParkingLot {
    public static void main(String[] args) throws IOException {

        Set<String> parkingLot = new HashSet<>();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String[] line = bufferedReader.readLine().split(", ");
            if (line[0].equals("END")) {
                break;
            }
            String number = line[1];
            if (line[0].equals("IN")) {
                parkingLot.add(number);
            } else if (line[0].equals("OUT")) {
                parkingLot.remove(number);
            }
        }
        if (parkingLot.size() > 0) {
            for (String car : parkingLot) {
                System.out.println(car);
            }
        } else {
            System.out.println("Parking Lot is Empty");
        }
    }
}
