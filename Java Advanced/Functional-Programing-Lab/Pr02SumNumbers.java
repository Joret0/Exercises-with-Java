import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Pr02SumNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] numbers = Arrays.stream(reader.readLine().split(", ")).mapToInt(Integer::parseInt).toArray();
        int count = numbers.length;
        int sum = Arrays.stream(numbers).sum();
        System.out.printf("Count = %d%n", count);
        System.out.printf("Sum = %d%n", sum);
    }
}
