import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Pr07PhoneNumbers {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Pattern pattern = Pattern.compile("([A-Z][a-zA-Z]*)[^a-zA-Z\\+]+?(?=\\+|[0-9]{2})([0-9\\+]{0,1}[0-9][0-9\\/(). -]*[0-9])");
        String text = reader.readLine();
        ArrayList<String> list = new ArrayList<>();
        while (!text.equals("END")) {
            Matcher matcher = pattern.matcher(text);
            while (matcher.find()) {
                String nameMatch = matcher.group(1);
                String numberMatch = matcher.group(2);
                numberMatch = numberMatch.replace("(", "");
                numberMatch = numberMatch.replace(")", "");
                numberMatch = numberMatch.replace("/", "");
                String result = "<li><b>%s:</b> %s</li>";
            }
        }
    }
}
