import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class p13_MagicExchangeableWords {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] array = reader.readLine().split("[\\t\\s ]+");
        String first = array[0];
        String second = array[1];
        System.out.println(areEqual(first, second));
    }

    private static boolean areEqual(String a, String b){
        int end = Math.max(a.length(), b.length());
        HashMap<Character, Character> map = new HashMap<>();
        for (int i = 0; i < end; i++) {
            if (i > b.length() - 1) {
                if (!map.containsKey(a.charAt(i))){
                    return false;
                } else {
                    continue;
                }
            }
            if (i > a.length() - 1){
                if (!map.containsValue(b.charAt(i))){
                    return false;
                } else {
                    continue;
                }
            }
            char firstChar = a.charAt(i);
            char secondChar = b.charAt(i);
            if (!map.containsKey(firstChar)){
                if (map.containsValue(secondChar)){
                    return false;
                } else {
                    map.put(firstChar, secondChar);
                }
            } else {
                if (!map.get(firstChar).equals(secondChar)){
                    return false;
                }
            }
        }
        return true;
    }
}
