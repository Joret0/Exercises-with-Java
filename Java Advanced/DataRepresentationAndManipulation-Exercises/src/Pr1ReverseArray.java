import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Pr1ReverseArray {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(bufferedReader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        reverse(input, 0, input.length - 1);
        for (int i : input) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    private static void reverse(int[] input, int i, int j) {
        if (i >= j) {
            return;
        }
        int a = input[i];
        input[i] = input[j];
        input[j] = a;
        reverse(input, i + 1, j - 1);
    }
}
