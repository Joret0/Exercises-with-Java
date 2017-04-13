import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Pr20URLParser {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input = reader.readLine();
        int firstPart = input.indexOf("://");

        if (firstPart > 0) {
            String protocol = input.substring(0, firstPart);
            if (input.substring(firstPart + 3).contains("/")) {
                int secondPart = input.indexOf("/", firstPart + 3);
                String server = input.substring(firstPart + 3, secondPart);
                String resource = input.substring(secondPart + 1);

                System.out.printf("[protocol] = \"%s\"%n", protocol);
                System.out.printf("[server] = \"%s\"%n", server);
                System.out.printf("[resource] = \"%s\"%n", resource);
            } else {
                String server = input.substring(firstPart + 3);
                System.out.printf("[protocol] = \"%s\"%n", protocol);
                System.out.printf("[server] = \"%s\"%n", server);
                System.out.printf("[resource] = \"\"%n");
            }
        } else if (firstPart <= 0) {
            String server = input.substring(0);
            System.out.printf("[protocol] = \"\"%n");
            System.out.printf("[server] = \"%s\"%n", server);
            System.out.printf("[resource] = \"\"%n");
        }
    }
}
