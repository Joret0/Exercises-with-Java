import jdk.nashorn.internal.runtime.regexp.joni.Regex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

public class Pr02MatchPhoneNumber {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String regex = "^\\+359-2-\\d{3}-\\d{4}|^\\+359\\s2\\s\\d{3}\\s\\d{4}\\b";
        String text = reader.readLine();
        while (!text.equals("end")) {
            if (Pattern.matches(regex, text)) {
                System.out.println(text);
            }
            text = reader.readLine();
        }
    }
}
