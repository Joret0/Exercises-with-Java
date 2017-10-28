import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Pr4UnicodeCharacters {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String input = bufferedReader.readLine();
        for (int i = 0; i < input.length(); i++) {
            System.out.print("\\u".concat(Integer.toHexString(input.charAt(i) | 0x10000).substring(1)));
        }
    }
}
