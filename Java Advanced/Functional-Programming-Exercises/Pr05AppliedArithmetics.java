import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Pr05AppliedArithmetics {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] numbers = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        String command = "";
        while (!(command = reader.readLine()).equals("end")) {
            switch (command) {
                case "add":
                    numbers = Arrays.stream(numbers).map(i -> i + 1).toArray();
                    break;
                case "subtract":
                    numbers = Arrays.stream(numbers).map(i -> i - 1).toArray();
                    break;
                case "multiply":
                    numbers = Arrays.stream(numbers).map(i -> i * 2).toArray();
                    break;
                case "print":
                    Arrays.stream(numbers).forEach(i -> System.out.print(i + " "));
                    System.out.println();
                    break;
            }
        }
        reader.close();
    }
}
