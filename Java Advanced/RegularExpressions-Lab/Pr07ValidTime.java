import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Pr07ValidTime {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = "";
        Pattern pattern = Pattern.compile("^(\\d{2}):(\\d{2}):(\\d{2})\\s[AP]M$");
        while (!(input = reader.readLine()).equals("END")) {
            Matcher matcher = pattern.matcher(input);

            if (matcher.find()) {
                if (isValidTime(matcher)) {
                    System.out.println("valid");
                }else {
                    System.out.println("invalid");
                }
            }else {
                System.out.println("invalid");
            }
        }
    }

    private static boolean isValidTime(Matcher matcher) {
        int oneGroup = Integer.parseInt(matcher.group(1));
        int twoGroup = Integer.parseInt(matcher.group(2));
        int threeGroup = Integer.parseInt(matcher.group(3));
        boolean isValid = oneGroup >= 1 && oneGroup <= 12 && twoGroup >= 0 && twoGroup <= 59 && threeGroup >= 0 && threeGroup <= 59;
        return isValid;
    }
}
