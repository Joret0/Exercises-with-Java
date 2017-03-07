import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class Pr05FilterByAge {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        LinkedHashMap< String, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            String[] info = reader.readLine().split(", ");
            int value = Integer.parseInt(info[1]);
            map.put(info[0], value);
        }
        String oldYoung = reader.readLine();
        int age = Integer.parseInt(reader.readLine());
        String format = reader.readLine();
        if (format.equals("name")) {
            if (oldYoung.equals("older")) {
                for (Map.Entry<String, Integer> entry : map.entrySet()) {
                    if (entry.getValue() >= age) {
                        System.out.println(entry.getKey());
                    }
                }
            } else {
                for (Map.Entry<String, Integer> entry : map.entrySet()) {
                    if (entry.getValue() < age) {
                        System.out.println(entry.getKey());
                    }
                }
            }
        } else if (format.equals("age")) {
            if (oldYoung.equals("older")) {
                for (Map.Entry<String, Integer> entry : map.entrySet()) {
                    if (entry.getValue() >= age) {
                        System.out.println(entry.getValue());
                    }
                }
            } else {
                for (Map.Entry<String, Integer> entry : map.entrySet()) {
                    if (entry.getValue() < age) {
                        System.out.println(entry.getValue());
                    }
                }
            }
        } else {
            if (oldYoung.equals("older")) {
                for (Map.Entry<String, Integer> entry : map.entrySet()) {
                    if (entry.getValue() >= age) {
                        System.out.printf("%s - %s%n", entry.getKey(), entry.getValue());
                    }
                }
            } else {
                for (Map.Entry<String, Integer> entry : map.entrySet()) {
                    if (entry.getValue() < age) {
                        System.out.printf("%s - %s%n", entry.getKey(), entry.getValue());
                    }
                }
            }
        }
    }
}
