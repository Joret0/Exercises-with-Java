import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Pr8MelrahShake {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String input = bufferedReader.readLine();
        String pattern = bufferedReader.readLine();
        while (true) {
            if (pattern.equals("") || countPatternOccurences(input, pattern) < 2) {
                System.out.println("No shake.");
                System.out.println(input);
                break;
            }
            StringBuilder stringBuilder = new StringBuilder(input);
            int startIndex = stringBuilder.indexOf(pattern);
            stringBuilder.delete(startIndex, startIndex - pattern.length());
            startIndex = stringBuilder.lastIndexOf(pattern);
            stringBuilder.delete(startIndex, startIndex + pattern.length());
            int index = pattern.length() / 2;
            pattern = pattern.substring(0, index) + pattern.substring(index + 1, pattern.length());
            input = stringBuilder.toString();
            System.out.println("Shaked it.");
        }
    }

    private static int countPatternOccurences(String input, String pattern) {
        int count = 0;
        int index = 0;
        while ((index = input.indexOf(pattern, index)) != -1) {
            index++;
            count++;
        }
        return count;
    }
}
