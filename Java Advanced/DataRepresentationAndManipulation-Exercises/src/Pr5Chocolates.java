import java.util.Arrays;
import java.util.Scanner;

public class Pr5Chocolates {

    private static int bestMin = Integer.MAX_VALUE;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int length = Integer.parseInt(scanner.nextLine());
        int[] line = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
        int count = Integer.parseInt(scanner.nextLine());
        Arrays.sort(line);
        getMinDiff(line, count);
        System.out.printf("Min Difference is %d.", bestMin);
    }

    private static void getMinDiff(int[] line, int count) {
        findBestCouple(line, 0, line.length - 1, count);
    }

    private static void findBestCouple(int[] line, int i, int j, int count) {
        if (i + count > j + 1) {
            return;
        }
        int currentCouple = getCurrentCollection(line, count, i);
        if (bestMin > currentCouple) {
            bestMin = currentCouple;
        }
        findBestCouple(line, i + 1, j, count);
    }

    private static int getCurrentCollection(int[] line, int count, int i) {
        int first = line[i];
        int last = line[count + i - 1];
        return Math.abs(last - first);
    }
}
