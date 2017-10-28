import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Pr13BlurFilter {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int blurAmount = Integer.parseInt(bufferedReader.readLine());
        int[] matrixSize = Arrays.stream(bufferedReader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        long[][] matrix = new long[matrixSize[0]][matrixSize[1]];

        for (int i = 0; i < matrixSize[0]; i++) {
            long[] matrixValue = Arrays.stream(bufferedReader.readLine().split("\\s+")).mapToLong(Long::parseLong).toArray();
            matrix[i] = matrixValue;
        }
        int[] targetCell = Arrays.stream(bufferedReader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        try {
            matrix[targetCell[0] - 1][targetCell[1] - 1] += blurAmount;
        } catch (IndexOutOfBoundsException ex) { }

        try {
            matrix[targetCell[0] - 1][targetCell[1]] += blurAmount;
        } catch (IndexOutOfBoundsException ex) { }

        try {
            matrix[targetCell[0] - 1][targetCell[1] + 1] += blurAmount;
        } catch (IndexOutOfBoundsException ex) { }



        try {
            matrix[targetCell[0]][targetCell[1] - 1] += blurAmount;
        } catch (IndexOutOfBoundsException ex) { }

        try {
            matrix[targetCell[0]][targetCell[1]] += blurAmount;
        } catch (IndexOutOfBoundsException ex) { }

        try {
            matrix[targetCell[0]][targetCell[1] + 1] += blurAmount;
        } catch (IndexOutOfBoundsException ex) { }



        try {
            matrix[targetCell[0] + 1][targetCell[1] - 1] += blurAmount;
        } catch (IndexOutOfBoundsException ex) { }

        try {
            matrix[targetCell[0] + 1][targetCell[1]] += blurAmount;
        } catch (IndexOutOfBoundsException ex) { }

        try {
            matrix[targetCell[0] + 1][targetCell[1] + 1] += blurAmount;
        } catch (IndexOutOfBoundsException ex) { }

        for (int i = 0; i < matrix.length; i++) {
            String result = Arrays.toString(matrix[i]).replace("[", "").replace("]", "").replace(",", "");
            System.out.println(result);
        }
    }
}
