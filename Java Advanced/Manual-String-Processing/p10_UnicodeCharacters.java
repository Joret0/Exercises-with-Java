import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p10_UnicodeCharacters {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        for (int i = 0; i < input.length(); i++) {
            System.out.print(toUnicode(input.charAt(i)));
        }
    }
    private static String toUnicode(char ch){
        return String.format("\\u%04x", (int) ch);
    }
}
