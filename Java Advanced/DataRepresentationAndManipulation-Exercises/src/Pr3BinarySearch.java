import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Pr3BinarySearch {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] elements = Arrays.stream(bufferedReader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int key = Integer.parseInt(bufferedReader.readLine());
        System.out.println(binarySearch(elements, key, 0, elements.length - 1));
    }

    private static int binarySearch(int[] nums, int key, int lo, int hi) {
        if (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (key < nums[mid]) {
                return binarySearch(nums, key, lo, mid - 1);
            } else if (key > nums[mid]) {
                return binarySearch(nums, key, mid + 1, hi);
            } else {
                return mid;
            }
        }
        return -1;
    }
}
