import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Pr06ReverseAndExclude {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> numbers = Arrays.stream(reader.readLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        int n = Integer.parseInt(reader.readLine());
        Collections.reverse(numbers);
        numbers.stream().filter(i -> i % n != 0).forEach(i -> System.out.print(i + " "));
        reader.close();
    }
}
