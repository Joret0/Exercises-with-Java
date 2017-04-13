import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Pr09MostFrequentNumber {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] numbers = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int frequentMax = 0;
        int counterMax = 0;

        for (int i = 0; i < numbers.length; i++) {
            int count = 0;
            for (int j = i; j < numbers.length; j++) {
                if (numbers[i] == numbers[j]) {
                    count++;
                    if (count > counterMax) {
                        counterMax = count;
                        frequentMax = numbers[i];
                    }
                }
            }
        }
        System.out.println(frequentMax);
    }
}
