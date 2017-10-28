import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Pr12AMinerTask {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String resources = "";
        Map<String, Integer> minerHolder = new HashMap<>();

        while (true) {
            resources = bufferedReader.readLine();
            if (resources.equals("stop")) {
                break;
            }
            int quantity = Integer.parseInt(bufferedReader.readLine());
            addResources(minerHolder, resources, quantity);
        }

        for (Map.Entry<String, Integer> entry : minerHolder.entrySet()) {
            System.out.printf("%s -> %s%n", entry.getKey(), entry.getValue());
        }
    }

    private static void addResources(Map<String, Integer> minerHolder, String resources, int quantity) {
        if (minerHolder.containsKey(resources)) {
            minerHolder.put(resources, minerHolder.get(resources) + quantity);
        } else {
            minerHolder.put(resources, quantity);
        }
    }
}
