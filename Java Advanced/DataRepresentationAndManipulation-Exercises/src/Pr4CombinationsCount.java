import java.math.BigInteger;
import java.util.Scanner;

public class Pr4CombinationsCount {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int k = Integer.parseInt(scanner.nextLine());
        System.out.println(getCombinationsCount(n, k));
    }

    private static BigInteger getCombinationsCount(int n, int k) {
        BigInteger divisible = getFactorial(new BigInteger(String.valueOf(n)));
        BigInteger divisor = getFactorial(new BigInteger(String.valueOf(n - k))).multiply(getFactorial(new BigInteger(String.valueOf(k))));
        return divisible.divide(divisor);
    }

    private static BigInteger getFactorial(BigInteger n) {
        if (n.equals(BigInteger.ONE)) {
            return BigInteger.ONE;
        }
        return n.multiply(getFactorial(n.subtract(BigInteger.ONE)));
    }
}
