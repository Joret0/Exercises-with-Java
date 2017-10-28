import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Pr6HitTheTarget {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        for (int i = 1; i <= 20; i++) {
            for (int j = 1; j <= 20; j++) {
                if (i + j == n) {
                    System.out.printf("%d + %d = %d%n", i, j, n);
                }
            }
        }
        for (int i = 1; i <= 20; i++) {
            for (int j = 1; j <= 20; j++) {
                if (i - j == n) {
                    System.out.printf("%d - %d = %d%n", i, j, n);
                }
            }
        }
    }
}
