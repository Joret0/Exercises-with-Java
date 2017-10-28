import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Pr1FillTheMatrix {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = bufferedReader.readLine().split(", ");
        int n = Integer.parseInt(input[0]);
        String type = input[1];
        int[][] matrix = new int[n][n];
        if (type.equals("A")) {
            int c = 1;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[j][i] = c;
                    c++;
                }
            }

            for (int[] ints : matrix) {
                for (int anInt : ints) {
                    System.out.printf("%d ", anInt);;
                }
                System.out.println();
            }
        } else if (type.equals("B")){
            int c = 1;
            for (int i = 0; i < matrix.length; i++) {
                if (i % 2 == 0) {
                    for (int j = 0; j < matrix[0].length; j++) {
                        matrix[j][i] = c;
                        c++;
                    }
                } else {
                    for (int j = matrix[0].length - 1; j >= 0; j--) {
                        matrix[j][i] = c;
                        c++;
                    }
                }
            }
            for (int[] ints : matrix) {
                for (int anInt : ints) {
                    System.out.printf("%d ", anInt);
                }
                System.out.println();
            }
        } else {
            System.out.println("Wrong type.");
        }
    }
}
