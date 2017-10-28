import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Pr4Greeting {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String firstName = bufferedReader.readLine();
        String secondName = bufferedReader.readLine();

        if (firstName.isEmpty()) {
            firstName = "*****";
        }

        if (secondName.isEmpty()) {
            secondName = "*****";
        }

        System.out.printf("Hello, %s %s!%n", firstName, secondName);
        bufferedReader.close();
    }
}
