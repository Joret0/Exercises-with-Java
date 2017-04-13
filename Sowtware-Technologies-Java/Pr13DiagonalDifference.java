import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Pr13DiagonalDifference {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        int[][] matrix = new int[n][];

        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        int primaryDiagonal = 0;
        int secondaryDiagonal = 0;

        for (int i = 0; i < n; i++) {
            primaryDiagonal += matrix[i][i];
        }

        for (int i = 0; i < n; i++) {
            secondaryDiagonal += matrix[i][matrix[i].length - 1 - i];
        }
        System.out.println(Math.abs(primaryDiagonal - secondaryDiagonal));
    }
}
