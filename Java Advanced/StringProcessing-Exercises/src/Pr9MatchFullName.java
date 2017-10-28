import java.util.Scanner;
import java.util.regex.Pattern;

public class Pr9MatchFullName {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        String pattern = "^([A-Z][a-z]+) ([A-Z][a-z]+)&";
        while (!name.equals("end")) {
            if (Pattern.matches(pattern, name)) {
                System.out.println(name);
            }
            name = scanner.nextLine();
        }
    }
}
