import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Pr3ParseTags {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String input = bufferedReader.readLine();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(input);
        String openTag = "<upcase>";
        String closeTag = "</upcase>";
        while (stringBuilder.toString().contains(openTag)) {
            int indexStart = stringBuilder.indexOf(openTag);
            int indexEnd = stringBuilder.indexOf(closeTag);
            String textToReplace = stringBuilder.substring(indexStart + openTag.length(), indexEnd).toUpperCase();
            stringBuilder.replace(indexStart, indexEnd + closeTag.length(), textToReplace);
        }
        System.out.println(stringBuilder.toString());
    }
}
