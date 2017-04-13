import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Pr15MaxPlatform3x3 {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        long[] size = Arrays.stream(reader.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
        long num1 = size[0];
        long num2 = size[1];
        long[][] numbers;
        numbers = ReadingInputNumbers(size);
        long[][] max3x3Platform = new long[3][3];
        FindingMaxPlatform(numbers);
    }

    private static void FindingMaxPlatform(long[][] numbers) {
        long[][] maxPlatform = new long[3][3];
        long bestSum = Long.MIN_VALUE;
        long bestRow = 0;
        long bestCol = 0;

        for (int row = 0; row < numbers[0].length - 2; row++) {
            for (int col = 0; col < numbers[1].length - 2; col++) {
                long currentSum = numbers[row][col] + numbers[row][col + 1] + numbers[row][col + 2] +
                        numbers[row + 1][col] + numbers[row + 1][col + 1] + numbers[row + 1][col + 2] +
                        numbers[row + 2][col] + numbers[row + 2][col + 1] + numbers[row + 2][col + 2];
                if (currentSum > bestSum) {
                    bestSum = currentSum;
                    bestRow = row;
                    bestCol = col;
                }
            }
        }
        System.out.println(bestSum);
        for (long rowSave = bestRow; rowSave < bestRow + 3; rowSave++) {
            for (long colSave = bestCol; colSave < bestCol + 3; colSave++) {
                System.out.println(numbers[(int) rowSave][(int) colSave] + " ");
            }
            System.out.println();
        }
    }

    private static long[][] ReadingInputNumbers(long[] matrixSize) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        long[][] readNumbers = new long[(int) matrixSize[0]][(int) matrixSize[1]];

        for (int rowRead = 0; rowRead < readNumbers[0].length; rowRead++) {
            String[] rowNumbers = reader.readLine().split("\\s+");

            for (int colRead = 0; colRead < readNumbers[1].length; colRead++) {
                readNumbers[rowRead][colRead] = Long.parseLong(rowNumbers[colRead]);
            }
        }
        return readNumbers;
    }
}
