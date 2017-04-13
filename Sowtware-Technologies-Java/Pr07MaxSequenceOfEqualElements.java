import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Pr07MaxSequenceOfEqualElements {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] array = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int max = 1;
        int count = 1;
        int position = 0;

        for (int i = 0; i < array.length; i++) {
            if (i - 1 >= 0 && array[i] == array[i - 1]){
                count++;
                if (max < count) {
                    max = count;
                    position = i - count + 1;
                }
            } else {
                count = 1;
            }
        }
        for (int i = position; i < position + max; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}
