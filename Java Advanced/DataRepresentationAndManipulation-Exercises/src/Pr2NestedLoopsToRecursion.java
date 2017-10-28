import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Pr2NestedLoopsToRecursion {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        int[] array = new int[n];
        printNestedLoops(array, n, 0);
    }

    private static void printNestedLoops(int[] array, int n, int loop) {
        if (loop == n) {
            print(array, n);
            return;
        }
        for (int i = 1; i <= n; i++) {
            array[loop] = i;
            printNestedLoops(array, n, loop + 1);
        }
    }

    private static void print(int[] array, int n) {
        int c = 0;
        for (int i : array) {
            if (c % n == 0) {
                System.out.println();
            }
            System.out.print(i + " ");
            c++;
        }
    }
}
