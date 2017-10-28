import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Pr11GameOfNames {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        HashMap<String, Long> information = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            String name = bufferedReader.readLine();
            long score = Long.parseLong(bufferedReader.readLine());
            information.put(name, score);
            for (int j = 0; j < name.length(); j++) {
                int number = name.charAt(j);
                if (number % 2 == 0) {
                    long newScore = information.get(name) + number;
                    information.put(name, newScore);
                } else {
                    long newScore = information.get(name) - number;
                    information.put(name, newScore);
                }
            }
        }

        Map<String, Long> resultMap = new LinkedHashMap<>();
        information.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .forEachOrdered(x -> resultMap.put(x.getKey(), x.getValue()));

        for (Map.Entry<String, Long> entry : resultMap.entrySet()) {
            System.out.printf("The winner is %s - %d points%n", entry.getKey(), entry.getValue());
            break;
        }
    }
}
