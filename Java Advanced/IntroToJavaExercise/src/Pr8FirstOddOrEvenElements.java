import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Pr8FirstOddOrEvenElements {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] arrayIntegers = Arrays.stream(bufferedReader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        String[] inputCommands = bufferedReader.readLine().split("\\s+");
        int number = Integer.parseInt(inputCommands[1]);
        String command = inputCommands[2];
        ArrayList<Integer> resultIntegers = new ArrayList<>();
        int counter = 0;
        if (command.equals("odd")) {
            for (int i = 0; i < arrayIntegers.length; i++) {
                if (arrayIntegers[i] % 2 != 0) {
                    resultIntegers.add(arrayIntegers[i]);
                    counter++;
                }
                if (counter == number) {
                    break;
                }
            }
        } else {
            for (int i = 0; i < arrayIntegers.length; i++) {
                if (arrayIntegers[i] % 2 == 0) {
                    resultIntegers.add(arrayIntegers[i]);
                    counter++;
                }
                if (counter == number) {
                    break;
                }
            }
        }

        for (Integer resultInteger : resultIntegers) {
            System.out.print(resultInteger + " ");
        }
        System.out.println();
    }
}
