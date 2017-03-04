import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P10QueryMess {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Pattern pattern = Pattern.compile("([^?=&]+)=([^?=&]+)");
        String text = "";
        while (!(text = reader.readLine()).equals("END")) {
            text = text.replaceAll("\\+", " ");
            text = text.replaceAll("%20", " ");
            text = text.replaceAll("\\s+", " ");

            LinkedHashMap<String, ArrayList<String>> map = new LinkedHashMap<>();
            Matcher matcher = pattern.matcher(text);

            while (matcher.find()) {
                String key = matcher.group(1).trim();
                String value = matcher.group(2).trim();
                if (!map.containsKey(key)) {
                    map.put(key, new ArrayList<>());
                }
                map.get(key).add(value);
            }
            map.entrySet().stream().forEach(a -> {
                System.out.print(a.getKey() + "=" + a.getValue());
            });
            System.out.println();
        }
    }
}
