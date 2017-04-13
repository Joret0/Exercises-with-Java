import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Pr11EqualSums {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] numbers = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        boolean found = false;

        for (int i = 0; i < numbers.length; i++) {
            long leftSum = 0;
            long rightSum = 0;

            for (int j = 0; j < i; j++) {
                leftSum += numbers[j];
            }

            for (int j = i + 1; j < numbers.length; j++) {
                rightSum += numbers[j];
            }

            if (leftSum == rightSum) {
                System.out.println(i);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("no");
        }
    }
}
