import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Pr08SumOfAllValues {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String keyString = reader.readLine();
        String input = reader.readLine();

        Pattern pattern = Pattern.compile("^([A-Za-z_]+)\\d.*?\\d([A-Za-z_]+)$");
        Matcher matcher = pattern.matcher(keyString);

        if (!matcher.find()) {
            System.out.println("<p>A key is missing</p>");
            return;
        }

        String startKey = matcher.group(1);
        String endKey = matcher.group(2);

        Pattern numPattern = Pattern.compile(startKey + "(.*?)" + endKey);
        Matcher numMatcher = numPattern.matcher(input);

        double sum = 0;

        while (numMatcher.find()) {
            try {
                sum += Double.parseDouble(numMatcher.group(1));
            }catch (Exception ex) {

            }
        }

        if (sum == 0) {
            System.out.println("<p>The total value is: <em>nothing</em></p>");
        }else {
            System.out.println(String.format("<p>The total value is: <em>%s</em></p>", new DecimalFormat("#.##").format(sum)));
        }
    }
}
