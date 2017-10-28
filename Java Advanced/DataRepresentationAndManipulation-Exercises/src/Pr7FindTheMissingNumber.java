import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Pr7FindTheMissingNumber {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Set<Integer> fullSet = new HashSet<>();
        for (int i = 1; i <= n; i++) {
            fullSet.add(i);
        }
        Set<Integer> inputArray = IntStream.of(Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .toArray()).boxed().collect(Collectors.toSet());

        fullSet.removeAll(inputArray);
        for (Integer integer : fullSet) {
            System.out.println(integer);
        }
    }
}
