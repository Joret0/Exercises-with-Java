import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Pr3DiagonalDifference {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        int primary = 0;
        int secondary = 0;
        for (int i = 0; i < n; i++) {
            String[] input = bufferedReader.readLine().split("\\s+");
            for (int j = 0; j < input.length; j++) {
                if (i == j) {
                    primary += Integer.parseInt(input[j]);
                }
                if (i == n - 1 - j) {
                    secondary += Integer.parseInt(input[j]);
                }
            }
        }
        System.out.println(Math.abs(primary - secondary));
    }
}
