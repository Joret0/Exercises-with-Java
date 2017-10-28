import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Pr10SemanticHTML {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String openTagRegex = "<div\\s+.*((?:id|class)\\s*=\\s*\\\"([a-zA-Z]*)\\\").*?>";
        String closeTagRegex = "<\\/div>\\s+(<!--\\s*([a-zA-Z]+)\\s*-->)";
        List<String> fixedLines = new ArrayList<>();

        while (true) {
            String input = bufferedReader.readLine();
            if (input.equals("END")) {
                break;
            }
            Matcher openTagMatcher = Pattern.compile(openTagRegex).matcher(input);
            boolean matched = false;
            if (openTagMatcher.find()) {
                String remove = openTagMatcher.group(1);
                String newTag = openTagMatcher.group(2);
                input = input.replace("div", newTag);
                input = input.replace(remove, "");
                input = input.replaceAll("\\s{2,}", " ");
                input = input.replace(" >", ">");
                fixedLines.add(input);
                matched = true;
            }
            Matcher closeTagMatcher = Pattern.compile(closeTagRegex).matcher(input);
            if (closeTagMatcher.find()) {
                String commend = closeTagMatcher.group(1);
                String newTag = closeTagMatcher.group(2);
                input = input.replace("div", newTag);
                input = input.replace(commend, "");
                fixedLines.add(input);
                matched = true;
            }
            if (!matched) {
                fixedLines.add(input);
            }
        }
        for (String fixedLine : fixedLines) {
            System.out.println(fixedLine);
        }
    }
}
