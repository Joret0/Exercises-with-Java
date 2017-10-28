import java.util.Scanner;

public class Pr5MaximalSum {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int[][] matrix = readMatrix();
        printBestSubMatrix(matrix);
    }

    private static void printBestSubMatrix(int[][] matrix) {
        int[][] bestSumMatrix = new int[3][3];
        long bestSum = 0;
        for (int i = 0; i < matrix.length - 2; i++) {
            for (int j = 0; j < matrix[0].length - 2; j++) {
                int[][] subMatrix = getSubMatrix(matrix, i, j);
                long currentSum = getSubMatrixSum(subMatrix);
                if (currentSum > bestSum) {
                    bestSum = currentSum;
                    bestSumMatrix = subMatrix;
                }
            }
        }
        printSubMatrix(bestSumMatrix, bestSum);
    }

    private static void printSubMatrix(int[][] bestSumMatrix, long bestSum) {
        System.out.println("Sum = " + bestSum);
        for (int[] ints : bestSumMatrix) {
            for (int anInt : ints) {
                System.out.printf("%d ", anInt);
            }
            System.out.println();
        }
    }

    private static long getSubMatrixSum(int[][] subMatrix) {
        long sum = 0;
        for (int[] ints : subMatrix) {
            for (int anInt : ints) {
                sum += anInt;
            }
        }
        return sum;
    }

    private static int[][] getSubMatrix(int[][] matrix, int i, int j) {
        int[][] subMatrix = new int[3][3];
        subMatrix[0][0] = matrix[i][j];
        subMatrix[0][1] = matrix[i][j + 1];
        subMatrix[0][2] = matrix[i][j + 2];
        subMatrix[1][0] = matrix[i + 1][j];
        subMatrix[1][1] = matrix[i + 1][j + 1];
        subMatrix[1][2] = matrix[i + 1][j + 2];
        subMatrix[2][0] = matrix[i + 2][j];
        subMatrix[2][1] = matrix[i + 2][j + 1];
        subMatrix[2][2] = matrix[i + 2][j + 2];
        return subMatrix;
    }

    private static int[][] readMatrix() {
        String[] line = scanner.nextLine().split("\\s+");
        int r = Integer.parseInt(line[0]);
        int c = Integer.parseInt(line[1]);
        int[][] matrix = new int[r][c];
        for (int i = 0; i < r; i++) {
            String[] currentLine = scanner.nextLine().split("\\s+");
            for (int j = 0; j < c; j++) {
                matrix[i][j] = Integer.parseInt(currentLine[j]);
            }
        }
        return matrix;
    }
}
