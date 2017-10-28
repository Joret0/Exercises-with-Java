import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Pr12ExtractEmails {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        Pattern pattern = Pattern.compile("(?:^| )([a-z][a-z0-9\\-\\._]+@[a-z0-9\\-]+(\\.[a-z0-9\\-]+){1,})");
        String text = bufferedReader.readLine();
        while (!text.equals("end")) {
            Matcher matcher = pattern.matcher(text);
            while (matcher.find()) {
                System.out.println(matcher.group());
            }
            text = bufferedReader.readLine();
        }
    }
}
