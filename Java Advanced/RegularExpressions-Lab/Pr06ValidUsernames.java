import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Pr06ValidUsernames {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = "";
        Pattern pattern = Pattern.compile("^[a-zA-Z0-9_-]{3,16}$");
        while (!(input = reader.readLine()).equals("END")) {
            Matcher matcher = pattern.matcher(input);
            if (matcher.find()){
                System.out.println("valid");
            }else {
                System.out.println("invalid");
            }
        }
    }
}
