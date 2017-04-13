import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Pr21ChangeToUppercase {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input = reader.readLine();
        Pattern pattern = Pattern.compile("\\<upcase\\>(.*?)\\</upcase\\>");
        Matcher matcher = pattern.matcher(input);
        while (matcher.find()) {
            input = input.replace(matcher.group(0), matcher.group(1).toUpperCase());
        }
        System.out.println(input);
    }
}
