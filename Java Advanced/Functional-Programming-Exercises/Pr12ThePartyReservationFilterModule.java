import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.function.Predicate;

public class Pr12ThePartyReservationFilterModule {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, Predicate<String>> map = new HashMap<>();
        String[] names = reader.readLine().split("\\s+");
        String line = "";
        while (!(line = reader.readLine()).equals("Print")) {
            String[] input = line.split(";");
            String command = input[0];
            String filterType = input[1];
            String filterParameter = input[2];
            Predicate<String> currentPredicate = getPredicate(filterType, filterParameter);
            switch (command) {
                case "Add filter":
                    map.put(filterType + filterParameter, currentPredicate);
                    break;
                case "Remove filter":
                    map.remove(filterType + filterParameter);
                    break;
            }
        }
        for (String name : names) {
            boolean isInvited = true;
            for (Predicate<String> predicate : map.values()) {
                if (predicate.test(name)) {
                    isInvited = false;
                }
            }
            if (isInvited) {
                System.out.print(name + " ");
            }
        }
    }

    private static Predicate<String> getPredicate(String filter, String parameter) {

        switch (filter) {
            case "Starts with":
                return s -> s.startsWith(parameter);
            case "Ends with":
                return s -> s.endsWith(parameter);
            case "Contains":
                return s -> s.contains(parameter);
            case "Length":
                return s -> s.length() == Integer.parseInt(parameter);
                default:
                    return null;
        }
    }
}
