import java.util.Scanner;

public class Pr5TransportPrice {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        double distanceKm = Double.parseDouble(scanner.nextLine());
        String dayTime = scanner.nextLine();
        double taxiInitialPrice = 0.70;
        double taxiDayPricePerKm = 0.79;
        double taxiNightPricePerKm = 0.90;
        double busPrice = 0.09;
        double trainPrice = 0.06;
        double amount = 0;
        if (distanceKm < 20) {
            if (dayTime.toLowerCase().equals("day")) {
                amount = taxiInitialPrice + (distanceKm * taxiDayPricePerKm);
            } else {
                amount = taxiInitialPrice + (distanceKm * taxiNightPricePerKm);
            }
        } else if (distanceKm >= 20 && distanceKm < 100) {
            amount = distanceKm * busPrice;
        } else if (distanceKm >= 100) {
            amount = distanceKm * trainPrice;
        }

        System.out.printf("%.2f", amount);
        scanner.close();
    }
}
