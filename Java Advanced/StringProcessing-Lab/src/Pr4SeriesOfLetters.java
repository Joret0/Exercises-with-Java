import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Pr4SeriesOfLetters {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String input = bufferedReader.readLine();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < input.length() - 1; i++) {
            if (input.charAt(i) == input.charAt(i + 1)) {
                if (input.length() - 2 == i) {
                    stringBuilder.append(input.charAt(i));
                }
                continue;
            } else {
                if (input.length() - 2 == i) {
                    stringBuilder.append(input.charAt(i));
                    stringBuilder.append(input.charAt(i + 1));
                } else {
                    stringBuilder.append(input.charAt(i));
                }
            }
        }
        System.out.println(stringBuilder.toString());
    }
}
