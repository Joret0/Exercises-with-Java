import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Pr18FitStringIn20Chars {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input = reader.readLine();

        if (input.length() < 20) {
            System.out.println(String.format("%-20s", input).replace(" ", "*"));
        } else {
            System.out.println(input.substring(0, 20));
        }
    }
}
