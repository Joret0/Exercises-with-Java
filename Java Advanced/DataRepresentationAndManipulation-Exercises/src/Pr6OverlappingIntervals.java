import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Pr6OverlappingIntervals {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        TreeMap<Integer, Integer> intervals = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            String[] currentLine = scanner.nextLine().split(",");
            intervals.put(Integer.parseInt(currentLine[0]), Integer.parseInt(currentLine[1]));
        }
        System.out.println(checkForOverlap(intervals));
    }

    private static boolean checkForOverlap(TreeMap<Integer, Integer> intervals) {
        Map.Entry<Integer, Integer> first = intervals.firstEntry();
        intervals.remove(intervals.firstKey());
        int prevEnd = first.getValue();

        for (Map.Entry<Integer, Integer> integerIntegerEntry : intervals.entrySet()) {
            int currentStart = integerIntegerEntry.getKey();
            if (prevEnd >= currentStart) {
                return true;
            }
            prevEnd = integerIntegerEntry.getValue();
        }
        return false;
    }
}
