import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Pr1HandScore {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] cards = bufferedReader.readLine().split("\\s+");
        Map<Character, List<Integer>> map = new HashMap<>();
        map.put('Y', new ArrayList<>());
        char lastSuit = '\0';

        for (int i = 0; i < cards.length; i++) {
            int num = 0;
            char suit = cards[i].charAt(cards[i].length() - 1);
            if (map.containsKey(suit)) {
                if (Character.isDigit(cards[i].charAt(0))) {
                    num = Integer.parseInt(cards[i].substring(0, cards[i].length() - 1));
                    if (suit == lastSuit) {
                        map.get(suit).add(num);
                    } else {
                        map.get('Y').add(num);
                        lastSuit = suit;
                    }
                } else {
                    switch (cards[i].charAt(0)) {
                        case 'J':
                            num = 12;
                            break;
                        case 'Q':
                            num = 13;
                            break;
                        case 'K':
                            num = 14;
                            break;
                        case 'A':
                            num = 15;
                            break;
                    }
                    if (suit == lastSuit) {
                        map.get(suit).add(num);
                    } else {
                        map.get('Y').add(num);
                        lastSuit = suit;
                    }
                }
            } else {
                map.put(suit, new ArrayList<>());
                lastSuit = suit;
                if (Character.isDigit(cards[i].charAt(0))) {
                    num = Integer.parseInt(cards[i].substring(0, cards[i].length() - 1));
                    map.get(suit).add(num);
                } else {
                    switch (cards[i].charAt(0)) {
                        case 'J':
                            num = 12;
                            break;
                        case 'Q':
                            num = 13;
                            break;
                        case 'K':
                            num = 14;
                            break;
                        case 'A':
                            num = 15;
                            break;
                    }
                    map.get(suit).add(num);
                }
            }
        }
        long sum = 0;
        for (Map.Entry<Character, List<Integer>> entry : map.entrySet()) {
            if (entry.getKey() != 'Y') {
                sum += entry.getValue().stream().mapToInt(Integer::intValue).sum() * entry.getValue().size();
            } else {
                sum += entry.getValue().stream().mapToInt(Integer::intValue).sum();
            }
        }
        System.out.println(sum);
    }
}
