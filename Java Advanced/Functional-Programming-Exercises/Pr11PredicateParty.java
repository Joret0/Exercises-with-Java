import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Predicate;

public class Pr11PredicateParty {

    private static Predicate<String> predicateToUse;

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> guestsList = new ArrayList<>(Arrays.asList(reader.readLine().split("\\s+")));
        String line = "";

        while (!(line = reader.readLine()).equals("Party!")) {
            String[] input = line.split("\\s+");
            String command = input[0];
            String option = input[1];
            String var = input[2];
            Predicate<String> length = s -> s.length() == Integer.parseInt(var);
            Predicate<String> start = s -> s.startsWith(var);
            Predicate<String> ends = s -> s.endsWith(var);
            switch (option) {
                case "Length":
                    predicateToUse = length;
                    break;
                case "StartsWith":
                    predicateToUse = start;
                    break;
                case "EndsWith":
                    predicateToUse = ends;
                    break;
            }
            switch (command) {
                case "Remove":
                    guestsList.removeIf(predicateToUse);
                    break;
                case "Double":
                    ArrayList<String> guestsAdd = new ArrayList<>();
                    for (String guest : guestsList) {
                        if (predicateToUse.test(guest)) {
                            guestsAdd.add(guest);
                        }
                        guestsAdd.add(guest);
                    }
                    guestsList = guestsAdd;
            }
        }
        if (guestsList.size() > 0) {
            System.out.println(String.join(", ", guestsList) + " are going to the party!");
        } else {
            System.out.println("Nobody is going to the party!");
        }
    }
}
