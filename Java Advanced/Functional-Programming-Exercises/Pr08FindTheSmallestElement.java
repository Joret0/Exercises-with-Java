import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.Function;

public class Pr08FindTheSmallestElement {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] numbers = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        Function<int[], Integer> function = element -> FindMinElementsIndex(element);
        System.out.println(function.apply(numbers));
    }

    private static Integer FindMinElementsIndex(int[] element) {
        int index = 0;
        int minElement = Integer.MAX_VALUE;
        for (int i = 0; i < element.length; i++) {
            if (minElement >= element[i]) {
                minElement = element[i];
                index = i;
            }
        }
        return index;
    }
}
