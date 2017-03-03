import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Pr01MatchCount {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String patternString = reader.readLine();
        String matcherString = reader.readLine();
        Pattern pattern = Pattern.compile(patternString);
        Matcher matcher = pattern.matcher(matcherString);
        int count = 0;
        while (matcher.find()) {
            count++;
        }
        System.out.println(count);
    }
}
