import java.math.BigInteger;
import java.util.Scanner;

public class Pr7ProductOfNumbersNM {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        BigInteger product = BigInteger.ONE;
        int a = n;

        do {
            BigInteger number = new BigInteger("" + n);
            product = product.multiply(number);
            n++;
        } while (n <= m);

        System.out.printf("product[%d..%d] = %d%n", a, m, product);
    }
}
