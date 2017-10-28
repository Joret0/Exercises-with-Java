import java.util.Scanner;
import java.util.regex.Pattern;

public class Pr10MatchPhoneNumber {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String phone = scanner.nextLine();
        String pattern = "^\\+359([ -])2\\1[0-9]{3}\\1[0-9]{4}&";
        while (!phone.equals("end")) {
            if (Pattern.matches(pattern, phone)) {
                System.out.println(phone);
            }
            phone = scanner.nextLine();
        }
    }
}
