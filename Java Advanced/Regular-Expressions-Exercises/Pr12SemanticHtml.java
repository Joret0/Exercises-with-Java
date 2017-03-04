import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Pr12SemanticHtml {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Pattern openPattern = Pattern.compile("(\\s*)?<div\\s*(.+)?(?:\\s*id\\s*=\\s*\"|\\s*class\\s*=\\s*\")\\s*([^\"]+\\s*)\"\\s*(.+)?>");
        Pattern closePattern = Pattern.compile("(\\s*)?(?:<\\s*\\/div\\s*>)\\s*<(?:[!-]+)\\s*(\\w+)\\s*(?:[-]+)>");
        String input = "";
        StringBuilder builder = new StringBuilder(input);

        while (!(input = reader.readLine()).equals("END")) {
            Matcher openMatcher = openPattern.matcher(input);
            Matcher closeMatcher = closePattern.matcher(input);

            if (openMatcher.find()) {
                if (openMatcher.group(1) != null) {
                    builder.append(openMatcher.group(1));
                }
                builder.append("<").append(openMatcher.group(3).trim());
                if (openMatcher.group(2) != null) {
                    String content = openMatcher.group(2).replaceAll("\\s+", " ").trim();
                    builder.append(" ").append(content);
                }
                if (openMatcher.group(4) != null) {
                    String content = openMatcher.group(4).replaceAll("\\s+", " ").trim();
                    builder.append(" ").append(content);
                }
                builder.append(">");
            }else if (closeMatcher.find()) {
                String frontPart = "";
                if (closeMatcher.group(1) != null) {
                    frontPart = closeMatcher.group(1);
                }
                builder.append(frontPart);
                builder.append("</").append(closeMatcher.group(2)).append(">");
            }else {
                builder.append(input);
            }
            builder.append(System.getProperty("line.separator"));
        }
        System.out.println(builder);
    }
}
