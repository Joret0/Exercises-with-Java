import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class Pr10ListOfPredicates {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int bound = Integer.parseInt(reader.readLine());
        int[] numbers = IntStream.range(1 , bound + 1).map(i -> i++).toArray();
        int[] dividers = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .distinct()
                .toArray();
        for (int divider : dividers) {
            Predicate<Integer> predicate = i -> i % divider == 0;
            numbers = Arrays.stream(numbers).filter(predicate::test).toArray();
        }
        Arrays.stream(numbers).forEach(i -> System.out.print(i + " "));
        reader.close();
    }
}
