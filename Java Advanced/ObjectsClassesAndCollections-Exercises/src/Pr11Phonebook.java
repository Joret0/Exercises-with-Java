import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Pr11Phonebook {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, String> phoneBook = new HashMap<>();
        boolean isSearch = false;

        while (true) {
            String input = bufferedReader.readLine();
            String[] inputInfo = input.split("-");
            String command = inputInfo[0];
            if (command.equals("stop")) {
                break;
            }
            if (command.equals("search")) {
                isSearch = true;
                continue;
            }
            if (!isSearch) {
                addContact(phoneBook, inputInfo);
            } else {
                isSearch = true;
                searchContact(phoneBook, command);
            }
        }
    }

    private static void searchContact(Map<String, String> phoneBook, String command) {
        if (phoneBook.containsKey(command)) {
            System.out.printf("%s -> %s%n", command, phoneBook.get(command));
        } else {
            System.out.printf("Contact %s does not exist.%n", command);
        }
    }

    private static void addContact(Map<String, String> phoneBook, String[] inputInfo) {
        phoneBook.put(inputInfo[0], inputInfo[1]);
    }
}
