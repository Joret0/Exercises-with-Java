import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Pr03SeriesOfLetters {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String text = reader.readLine();
        System.out.println(text.replaceAll("([a-zA-Z])(\\1+)", "$1"));
    }
}
