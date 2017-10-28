import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Pr1CountSubstringOccurrences {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String input = bufferedReader.readLine().toLowerCase();
        String key = bufferedReader.readLine().toLowerCase();

        int count = 0;
        for (int i = 0; i < input.length() - key.length(); i++) {
            String temp = input.substring(i, key.length() + i);
            if (key.equals(temp)) {
                count++;
            }
        }
        System.out.println(count);
    }
}
