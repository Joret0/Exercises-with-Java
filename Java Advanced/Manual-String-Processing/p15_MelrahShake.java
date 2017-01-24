import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p15_MelrahShake {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        String pattern = reader.readLine();

        while (true){
            if (pattern.equals("") || countStringOccurrences(input, pattern) < 2){
                System.out.println("No shake.");
                System.out.println(input);
                break;
            }
            StringBuilder builder = new StringBuilder(input);
            int start = builder.indexOf(pattern);
            int end = pattern.length();
            builder.delete(start, start + end);
            start = builder.lastIndexOf(pattern);
            builder.delete(start, start + end);
            int index = pattern.length() / 2;
            pattern = pattern.substring(0, index) + pattern.substring(index + 1, pattern.length());
            input = builder.toString();
            System.out.println("Shaked it.");
        }
    }

    private static int countStringOccurrences(String text, String word){
        int count = 0;
        int i = 0;
        while ((i = text.indexOf(word, i)) != - 1){
            i++;
            count++;
        }
        return count;
    }
}
