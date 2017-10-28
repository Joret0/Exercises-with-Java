import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Pr3TextFilter {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] bannedWords = bufferedReader.readLine().split(", ");
        String text = bufferedReader.readLine();
        for (int i = 0; i < bannedWords.length; i++) {
            String stars = "";
            for (int j = 0; j < bannedWords[i].length(); j++) {
                stars += "*";
            }
            text = text.replace(bannedWords[i], stars);
        }
        System.out.println(text);
    }
}
