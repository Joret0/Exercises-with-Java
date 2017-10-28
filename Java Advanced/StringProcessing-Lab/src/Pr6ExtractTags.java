import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Pr6ExtractTags {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        List<String> tags = new ArrayList<>();
        while (true) {
            String line = bufferedReader.readLine().trim();
            if (line.equals("END")) {
                break;
            }
            String regex = "<.*?>";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(line);
            while (matcher.find()) {
                tags.add(matcher.group());
                line = line.replace(matcher.group(), "");
            }
        }
        for (String tag : tags) {
            System.out.println(tag);
        }
    }
}
