import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.Collator;
import java.util.*;

public class p11_Palindromes {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        HashSet<String> set = new HashSet<>();
        String[] split = input.split("[, \\.!?]+");
        for (int i = 0; i < split.length; i++) {
            String current = split[i];
            String firstPart = "";
            String secondPart = "";
            for (int j = 0; j < current.length() / 2; j++) {
                firstPart += current.charAt(j);
            }
            for (int j = current.length() - 1; current.length() % 2 == 1 ? j > current.length() / 2 : j >= current.length() / 2; j--) {
                secondPart += current.charAt(j);
            }
            if (firstPart.equals(secondPart)){
                set.add(current);
            }
        }
        List<String> asList = new ArrayList<>(set);
        Collator collator = Collator.getInstance(Locale.UK);
        Collections.sort(asList, collator);
        System.out.println(asList);
    }
}
