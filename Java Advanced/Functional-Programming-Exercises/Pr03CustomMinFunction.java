import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.Function;

public class Pr03CustomMinFunction {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] numbers = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        Function<int[], Integer> function = nums -> getMinValue(nums);
        System.out.println(function.apply(numbers));
    }

    private static Integer getMinValue(int[] nums) {
        int minValue = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < minValue) {
                minValue = nums[i];
            }
        }
        return minValue;
    }
}
