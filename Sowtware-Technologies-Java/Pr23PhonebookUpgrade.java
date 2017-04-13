import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

public class Pr23PhonebookUpgrade {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        TreeMap<String, String> treeMap = new TreeMap<>();
        String input = "";
        while (!(input = reader.readLine()).equals("END")) {
            String[] info = input.split("\\s+");
            String command = info[0];
            if (command.equals("A")) {
                String name = info[1];
                String tell = info[2];
                treeMap.put(name, tell);
            } else if (command.equals("S")) {
                String name = info[1];
                if (treeMap.containsKey(name)) {
                    System.out.printf("%s -> %s%n", name, treeMap.get(name));
                }
            } else if (command.equals("ListAll")) {
                for (Map.Entry<String, String> entry : treeMap.entrySet()) {
                    System.out.printf("%s -> %s%n", entry.getKey(), entry.getValue());
                }
            }
        }
    }
}
