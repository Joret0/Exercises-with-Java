import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Pr142x2SquaresInMatrix {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] input = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        if (input.length < 2) {
            System.out.println(0);
        } else {
            int rows = input[0];
            int cols = input[1];

            char[][] matrix = new char[rows][];

            for (int row = 0; row < rows; row++) {
                matrix[row] = reader.readLine().replace(" ", "").toCharArray();
            }
            int count = 0;
            for (int row = 0; row < rows - 1; row++) {
                for (int col = 0; col < cols - 1; col++) {
                    if (matrix[row][col] == matrix[row][col + 1] && matrix[row][col] == matrix[row + 1][col] && matrix[row][col] == matrix[row + 1][col + 1]){
                        count++;
                    }
                }
            }
            System.out.println(count);
        }
    }
}
