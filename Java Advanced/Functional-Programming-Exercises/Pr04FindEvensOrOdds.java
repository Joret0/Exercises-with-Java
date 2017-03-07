import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.IntPredicate;
import java.util.stream.IntStream;

public class Pr04FindEvensOrOdds {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] bounds = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int[] numbers = IntStream.range(bounds[0], bounds[1] + 1).map(i -> i++).toArray();
        String command = reader.readLine();
        IntPredicate isEven = i -> i % 2 == 0;
        IntPredicate isOdd = i -> i % 2 != 0;
        switch (command) {
            case "odd":
                Arrays.stream(numbers).filter(isOdd).forEach(e -> System.out.print(e + " "));
                break;
            case "even":
                Arrays.stream(numbers).filter(isEven).forEach(e -> System.out.print(e + " "));
                break;
        }
    }
}
