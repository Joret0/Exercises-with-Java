import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.TreeSet;

public class Pr5SoftUniParty {
    public static void main(String[] args) throws IOException {

        Set<String> guests = new TreeSet<>();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        boolean isPartyStarted = false;

        while (true) {
            String line = bufferedReader.readLine();
            if (line.equals("PARTY")) {
                isPartyStarted = true;
                continue;
            }
            if (line.equals("END")) {
                break;
            }
            if (!isPartyStarted) {
                guests.add(line);
            } else {
                guests.remove(line);
            }
        }
        System.out.println(guests.size());
        for (String guest : guests) {
            System.out.println(guest);
        }
    }
}
