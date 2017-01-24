import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p06_CountSubstringOccurrences {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String text = reader.readLine().toLowerCase();
        String word = reader.readLine().toLowerCase();
        int count = countStringOccurrences(text, word);
        System.out.println(count);
    }

    public static int countStringOccurrences(String text, String word){
        int count = 0;
        int i = 0;
        while ((i = text.indexOf(word, i)) != -1){
            i++;
            count++;
        }
        return count;
    }
}
