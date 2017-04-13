import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Pr04VowelOrDigit {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        char input = reader.readLine().charAt(0);
        String result = "other";
        if (Character.isLetter(input)) {

            switch (input) {
                case 'a':
                    result = "vowel";
                    break;
                case 'u':
                    result = "vowel";
                    break;
                case 'e':
                    result = "vowel";
                    break;
                case 'i':
                    result = "vowel";
                    break;
                case 'o':
                    result = "vowel";
                    break;
                case 'y':
                    result = "vowel";
                    break;
            }
        } else if (Character.isDigit(input)) {
            result = "digit";
        }

        System.out.println(result);
    }
}
