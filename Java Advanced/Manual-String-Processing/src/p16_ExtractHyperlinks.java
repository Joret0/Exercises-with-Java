import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class p16_ExtractHyperlinks {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = "";
        Pattern pattern = Pattern.compile("<a\\s*([^>]\\s*)*?href\\s*=\\s*(?:'([^']*)'|\"([^\"]*)\"|([^\\s>]+))[^>]*>");
        StringBuilder builder = new StringBuilder();
        while (!(input = reader.readLine()).equals("END")){
            builder.append(input);
        }
        Matcher matcher = pattern.matcher(builder.toString());
        while (matcher.find()){
            if (matcher.group(3) != null){
                System.out.println(matcher.group(3));
            } else if (matcher.group(4) != null){
                System.out.println(matcher.group(4));
            } else {
                System.out.println(matcher.group(2));
            }
        }
    }
}
