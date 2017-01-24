import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p01_ReverseString {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder builder = new StringBuilder();
        String input = reader.readLine();

        for (int i = input.length() - 1; i >= 0; i--) {
            builder.append(input.charAt(i));
        }
        System.out.println(builder);
    }
}
