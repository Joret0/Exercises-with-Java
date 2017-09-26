import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Pr4MaximumSumOf2x2Submatrix {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] inputParametersMatrix = bufferedReader.readLine().split(", ");
        int rows = Integer.parseInt(inputParametersMatrix[0]);
        int cols = Integer.parseInt(inputParametersMatrix[1]);
        int[][] matrix = new int[rows][cols];
        for (int row = 0; row < rows; row++) {
            String[] inputTokens = bufferedReader.readLine().split(", ");
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = Integer.parseInt(inputTokens[col]);
            }
        }
        int bestSum = Integer.MIN_VALUE;
        int resultRow = 0;
        int resultCol = 0;
        for (int row = 0; row < matrix.length - 1; row++) {
            for (int col = 0; col < matrix[row].length - 1; col++) {
                int sum = matrix[row][col] + matrix[row][col + 1] +
                        matrix[row + 1][col] + matrix[row + 1][col + 1];

                if (sum > bestSum) {
                    bestSum = sum;
                    resultRow = row;
                    resultCol = col;
                }
            }
        }
        int sum = matrix[resultRow][resultCol] + matrix[resultRow][resultCol + 1] + matrix[resultRow + 1][resultCol] + matrix[resultRow + 1][resultCol + 1];
        System.out.println(matrix[resultRow][resultCol] + " " + matrix[resultRow][resultCol + 1]);
        System.out.println(matrix[resultRow + 1][resultCol] + " " + matrix[resultRow + 1][resultCol + 1]);
        System.out.println(sum);
    }
}
