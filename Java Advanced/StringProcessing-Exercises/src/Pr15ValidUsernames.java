import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Pr15ValidUsernames {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String text = reader.readLine();
        reader.close();

        Pattern pattern = Pattern.compile("(\\w+)");
        Matcher matcher = pattern.matcher(text);
        ArrayList<String> usernames = new ArrayList<>();

        while (matcher.find()) {
            if (matcher.group().length() >= 3 && matcher.group().length() <= 25) {
                if (!Character.isDigit(matcher.group().charAt(0))) {
                    usernames.add(matcher.group());
                }
            }
        }
        ArrayList<String> result = new ArrayList<>();
        int sum = usernames.get(0).length() + usernames.get(1).length();
        result.add(usernames.get(0));
        result.add(usernames.get(1));
        for (int i = 1; i < usernames.size() - 1; i++) {
            String first = usernames.get(i);
            String second = usernames.get(i + 1);
            if (first.length() + second.length() > sum) {
                sum = first.length() + second.length();
                result.clear();
                result.add(first);
                result.add(second);
            }
        }
        for (String username : result) {
            System.out.println(username);
        }
    }
}
