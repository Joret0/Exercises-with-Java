import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

public class Pr10CountSymbols {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        char[] line = bufferedReader.readLine().toCharArray();
        Map<Character, Integer> symbols = new TreeMap<>();
        for (char c : line) {
            if (!symbols.containsKey(c)) {
                symbols.put(c, 1);
            } else {
                symbols.put(c , symbols.get(c) + 1);
            }
        }
        for (Map.Entry<Character, Integer> entry : symbols.entrySet()) {
            System.out.printf("%c: %d time/s%n", entry.getKey(), entry.getValue());
        }
    }
}
