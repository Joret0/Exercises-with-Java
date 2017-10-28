import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Pr7ValidUsernames {
    public static void main(String[] args) throws IOException {

        List<String> validUserNames = new ArrayList<>();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String line = bufferedReader.readLine();
        String regex = "^[A-Za-z\\d_-]{3,16}$";
        Pattern pattern = Pattern.compile(regex);
        while (!line.equals("END")) {
            Matcher matcher = pattern.matcher(line);
            if (matcher.find()) {
                validUserNames.add("valid");
            } else {
                validUserNames.add("invalid");
            }
            line = bufferedReader.readLine();
        }

        if (validUserNames.contains("valid")) {
            for (String validUserName : validUserNames) {
                System.out.println(validUserName);
            }
        }
    }
}
