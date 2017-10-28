import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Pr7LettersChangeNumbers {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = bufferedReader.readLine().split("\\s+");
        double sum = 0;
        for (int i = 0; i < input.length; i++) {
            char firstLetter = input[i].charAt(0);
            char lastLetter = input[i].charAt(input[i].length() - 1);
            double number = Double.parseDouble(input[i].substring(1, input[i].length() - 1));
            int firstLetterPosition = firstLetter >= 'A' && firstLetter <= 'Z' ?
                    firstLetter - 64 : firstLetter - 96;
            int lastLetterPosition = lastLetter >= 'A' && lastLetter <= 'Z' ?
                    lastLetter - 64 : lastLetter - 96;
            if (Character.isUpperCase(firstLetter)) {
                number /= firstLetterPosition;
            } else {
                number *= firstLetterPosition;
            }
            if (Character.isUpperCase(lastLetter)) {
                number -= lastLetterPosition;
            } else {
                number += lastLetterPosition;
            }
            sum += number;
        }
        System.out.printf("%.2f", sum);
    }
}
