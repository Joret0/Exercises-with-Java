import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Pr08MaSequenceOfIncreasingElements {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] array = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int currentCount = 0;
        int startCurrent = 0;
        int maxCount = 0;
        int startMax = 0;

        for (int i = 1; i < array.length; i++) {
            if (array[i] - array[i - 1] >= 1) {
                currentCount++;
                startCurrent = i - currentCount;

                if (currentCount > maxCount) {
                    maxCount = currentCount;
                    startMax = startCurrent;
                }
            } else {
                currentCount = 0;
            }
        }
        for (int i = startMax; i <= startMax + maxCount; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}
