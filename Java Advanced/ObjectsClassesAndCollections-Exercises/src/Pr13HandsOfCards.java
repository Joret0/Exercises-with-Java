import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Pr13HandsOfCards {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String line = bufferedReader.readLine();
        HashMap<String, List<Integer>> desk = new LinkedHashMap<>();
        HashMap<String, Integer> typesDict = new HashMap<>();
        typesDict.put("S", 4);
        typesDict.put("H", 3);
        typesDict.put("D", 2);
        typesDict.put("C", 1);

        while (!line.equals("JOKER")) {
            List<String> asd = Arrays.stream(line.split(":")).filter(x -> !x.equals("")).collect(Collectors.toList());
            String name = asd.toArray(new String[asd.size()])[0];
            String cards = asd.get(1).trim();
            List<String> temp = Arrays.stream(cards.split(", ")).filter(x -> !x.equals("")).collect(Collectors.toList());
            String[] cardsArray = temp.toArray(new String[temp.size()]);
            for (String current : cardsArray) {
                String type = String.valueOf(current.charAt(current.length() - 1));
                int power = getPower(current);
                List<Integer> temporally = new ArrayList<>();
                if (desk.containsKey(name)) {
                    temporally = desk.get(name);

                    if (!temporally.contains(power * typesDict.get(type))) {
                        temporally.add(power * typesDict.get(type));
                        desk.put(name, temporally);
                    }
                }
                if (!temporally.contains(power * typesDict.get(type))) {
                    temporally.add(power * typesDict.get(type));
                    desk.put(name, temporally);
                }
            }
            line = bufferedReader.readLine();
        }
        for (Map.Entry<String, List<Integer>> entry : desk.entrySet()) {
            System.out.printf("%s: %d%n", entry.getKey(), getSumOfList(entry.getValue()));
        }
    }

    private static int getSumOfList(List<Integer> value) {
        int sum = 0;
        for (Integer integer : value) {
            sum += integer;
        }
        return sum;
    }

    private static int getPower(String current) {
        Map<String, Integer> powers = new HashMap<>();
        powers.put("J", 11);
        powers.put("Q", 12);
        powers.put("K", 13);
        powers.put("A", 14);

        String powerStr = current.substring(0, current.length() - 1);

        if (powers.containsKey(powerStr)) {
            return powers.get(powerStr);
        }
        return Integer.parseInt(powerStr);
    }
}
