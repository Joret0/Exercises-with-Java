import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

public class Pr01MatchFullName {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String regex = "^[A-Z][a-z]+ [A-Z][a-z]+$";
        String text = reader.readLine();
        while (!text.equals("end")) {
            if (Pattern.matches(regex, text)) {
                System.out.println(text);
            }
            text = reader.readLine();
        }
    }
}
