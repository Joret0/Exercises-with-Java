import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.function.Predicate;

public class Pr13InfernoIII {
    private static int[] numberArray;
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        numberArray = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        HashMap<String, Predicate<Integer>> excludes = new HashMap<>();
        String line = "";
        while (!(line = reader.readLine()).equals("Forge")) {
            String[] input = line.split(";");
            String command = input[0];
            String filterType = input[1];
            int filterSum = Integer.parseInt(input[2]);
            
            Predicate<Integer> currentPredicate = getPredicate(filterType, filterSum);
            switch (command) {
                case "Exclude":
                    excludes.put(filterType + filterSum, currentPredicate);
                    break;
                case "Reverse":
                    excludes.remove(filterType + filterSum);
                    break;
            }
        }
        for (int i = 0; i < numberArray.length; i++) {
            boolean isFiltered = false;
            for (Predicate<Integer> predicate : excludes.values()) {
                if (predicate.test(i)) {
                    isFiltered = true;
                    break;
                }
            }
            if (!isFiltered) {
                System.out.print(numberArray[i] + " ");
            }
        }
    }

    private static Predicate<Integer> getPredicate(String filterType, int filterSum) {

        switch (filterType) {
            case "Sum Left":
                return i -> (i > 0 ? numberArray[i - 1] : 0) + numberArray[i] == filterSum;
            case "Sum Right":
                return i -> (i < numberArray.length - 1 ? numberArray[i + 1] : 0) + numberArray[i] == filterSum;
            case "Sum Left Right":
                return i -> (i > 0 ? numberArray[i - 1] : 0) + (i < numberArray.length - 1 ? numberArray[i + 1] : 0) + numberArray[i] == filterSum;
            default:
                return null;
        }
    }
}
