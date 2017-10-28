import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Pr16ExtractHyperlinks {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder text = new StringBuilder();
        while (true) {
            String line = reader.readLine();
            if (line.equals("END")) {
                break;
            }
            text.append(line);
        }
        ArrayList<String> aTags = new ArrayList<>();
        while (true) {
            int openingTag = text.indexOf("<a");
            int closingTag = text.indexOf(">", openingTag);
            if (openingTag == -1 || closingTag == -1) {
                break;
            }
            String tag = text.substring(openingTag, closingTag);
            aTags.add(tag);
            text = new StringBuilder(text.substring(closingTag));
        }
        for (String aTag : aTags) {
            aTag = aTag.replaceAll("\\s+", " ");
            aTag = aTag.replace("=", " = ") + " ";
            int hrefIndex = aTag.lastIndexOf("href") + 4;
            int nextEquals = aTag.indexOf("=", hrefIndex) + 1;
            if (nextEquals == 0) {
                continue;
            }
            int index = nextEquals;
            while (aTag.charAt(index) == '\"' || aTag.charAt(index) == '\'' || aTag.charAt(index) == ' ') {
                index++;
            }
            int firstIndex = index;
            char delimiter = aTag.charAt(firstIndex - 1);
            while (index < aTag.length() && aTag.charAt(index) != delimiter) {
                index++;
            }
            int lastIndex = index;
            String link = aTag.substring(firstIndex, lastIndex);
            link = link.replace(" = ", "=").trim();
            System.out.println(link);
        }
    }
}
