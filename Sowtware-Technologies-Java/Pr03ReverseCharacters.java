import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Pr03ReverseCharacters {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input = reader.readLine();
        StringBuilder builder = new StringBuilder();
        while (!input.equals("")) {

            builder.append(input);
            input = reader.readLine();
        }

        builder.reverse();

        System.out.println(builder);
    }
}
