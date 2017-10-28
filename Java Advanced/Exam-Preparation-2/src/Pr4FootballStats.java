import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Pr4FootballStats {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, String> resultMap = new TreeMap<>();

        while (true) {
            String input = bufferedReader.readLine();
            if (input.equals("Season End")) {
                break;
            }
            String[] data = input.split("result");
            String[] teams = data[0].split(" - ");
            String team1 = teams[0].trim();
            String team2 = teams[1].trim();
            String[] scores = data[1].split(":");
            int scoreTeam1 = Integer.parseInt(scores[0].trim());
            int scoreTeam2 = Integer.parseInt(scores[1].trim());
            String keyMap = String.format("%s - %s", team1, team2);
            String valueMap = String.format("%d:%d", scoreTeam1, scoreTeam2);
            resultMap = addData(keyMap, valueMap, resultMap);
            keyMap = String.format("%s - %s", team2, team1);
            valueMap = String.format("%d:%d", scoreTeam2, scoreTeam1);
            resultMap = addData(keyMap, valueMap, resultMap);

        }
        String[] teams = bufferedReader.readLine().split(", ");
        for (int i = 0; i < teams.length; i++) {
            String key = teams[i];

            for (Map.Entry<String, String> entry : resultMap.entrySet()) {
                int index = entry.getKey().indexOf(" ");
                String mapKey = entry.getKey().substring(0, index);
                if (key.equals(mapKey)) {
                    System.out.printf("%s -> %s%n", entry.getKey(), entry.getValue());
                }
            }
        }

    }

    private static Map<String, String> addData(String keyMap, String valueMap, Map<String, String> resultMap) {
        if (!resultMap.containsKey(keyMap)) {
            resultMap.put(keyMap, valueMap);
        }
        return resultMap;
    }
}
