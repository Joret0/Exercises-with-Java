import java.math.BigDecimal;
import java.util.Scanner;

public class Pr3EuroTrip {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        double quantity = Double.parseDouble(scanner.nextLine());
        BigDecimal rate = new BigDecimal("4210500000000");
        double priceKg = 1.20;
        BigDecimal wurstPrice = new BigDecimal(quantity * priceKg);
        BigDecimal result = wurstPrice.multiply(rate);
        System.out.printf("%.2f marks", result);
    }
}
