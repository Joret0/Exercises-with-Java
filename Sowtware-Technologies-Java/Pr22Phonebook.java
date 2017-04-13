import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Pr22Phonebook {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, String> map = new HashMap<>();
        String input = "";
        while (!(input = reader.readLine()).equals("END")) {
            String[] info = input.split("\\s+");
            String command = info[0];
            if (command.equals("A")) {
                String name = info[1];
                String tell = info[2];
                map.put(name, tell);
            } else if (command.equals("S")) {
                String name = info[1];
                if (map.containsKey(name)) {
                    System.out.printf("%s -> %s%n", name, map.get(name));
                } else {
                    System.out.printf("Contact %s does not exist.%n", name);
                }
            } else if (command.equals("ListAll")) {
                TreeMap<String, String> treeMap = new TreeMap<>(map);
                for (Map.Entry<String, String> entry : treeMap.entrySet()) {
                    System.out.printf("%s -> %s%n", entry.getKey(), entry.getValue());
                }
            }
        }
    }
}
