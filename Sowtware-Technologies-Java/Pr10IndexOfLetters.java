import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Pr10IndexOfLetters {
    public static void main(String[] args) throws IOException {
        
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        char[] input = reader.readLine().toCharArray();

        for (int i = 0; i < input.length; i++) {
            System.out.printf("%s -> %s%n", input[i], input[i] - 'a');
        }
    }
}
