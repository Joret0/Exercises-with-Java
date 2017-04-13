import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Pr02BooleanVariable {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input = reader.readLine();

        if (input.equals("True")) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}
