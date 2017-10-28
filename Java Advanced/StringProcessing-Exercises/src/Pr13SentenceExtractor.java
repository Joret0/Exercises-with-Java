import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Pr13SentenceExtractor {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String key = bufferedReader.readLine();
        String text = bufferedReader.readLine();
        Pattern pattern = Pattern.compile("[^.?!]*(?:[.?\\s!])" + key + "(?=[\\s.?!])[^.?!]*[.?!]");
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}
