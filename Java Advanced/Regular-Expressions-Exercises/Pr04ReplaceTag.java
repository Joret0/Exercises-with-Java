import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Pr04ReplaceTag {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder builder = new StringBuilder();
        Pattern pattern = Pattern.compile("(<a).*?(>)");
        String text = reader.readLine();
        while (!text.equals("END")) {
            Matcher matcher = pattern.matcher(text);
            if (matcher.find()) {
                text = text.replaceAll("</a>", "[/URL]");
                text = text.replaceAll(matcher.group(1), "[URL");
                text = text.replaceAll(matcher.group(2), "]");
                builder.append(text);
            }
            text = reader.readLine();
        }
        System.out.println(builder);
    }
}
