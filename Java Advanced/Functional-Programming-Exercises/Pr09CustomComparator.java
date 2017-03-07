import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Pr09CustomComparator {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> numbers = Arrays.stream(reader.readLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
        numbers.stream().sorted(customComparator).forEach(i -> System.out.print(i + " "));
    }
    private static Comparator<Integer> customComparator = (first, second) -> {
        if (first % 2 == 0 && second % 2 != 0) {
            return -1;
        } else if (first % 2 != 0 && second % 2 == 0) {
            return 1;
        }else {
            return first - second;
        }
    };
}
