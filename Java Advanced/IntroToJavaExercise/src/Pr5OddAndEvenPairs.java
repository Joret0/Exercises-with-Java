import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Pr5OddAndEvenPairs {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] input = bufferedReader.readLine().split("\\s+");

        if (input.length % 2 == 0) {
            int a = 0;
            int b = 0;
            for (int i = 0; i < input.length - 1; i++) {
                a = Integer.parseInt(input[i]);
                b = Integer.parseInt(input[i + 1]);
                if (a % 2 == 0 && b % 2 == 0) {
                    System.out.printf("%d, %d -> both are even%n", a, b);
                } else if (a % 2 != 0 && b % 2 != 0) {
                    System.out.printf("%d, %d -> both are odd%n", a, b);
                } else {
                    System.out.printf("%d, %d -> different%n", a, b);
                }
                i++;
            }
        } else {
            System.out.printf("invalid length%n");
        }
    }
}
