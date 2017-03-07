import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class Pr01SortOddNumbers {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> numbers = Arrays.stream(reader.readLine().split(", ")).map(s -> Integer.valueOf(s.trim())).collect(Collectors.toList());
        numbers.removeIf(n -> n % 2 != 0);
        System.out.println(numbers.stream().map(n -> n.toString()).collect(Collectors.joining(", ")));
        numbers.sort((a, b) -> a.compareTo(b));
        System.out.println(numbers.stream().map(n -> n.toString()).collect(Collectors.joining(", ")));
    }
}
