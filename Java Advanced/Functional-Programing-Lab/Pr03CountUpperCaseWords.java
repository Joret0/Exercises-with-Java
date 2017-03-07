import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Pr03CountUpperCaseWords {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<String> words = Arrays.stream(reader.readLine().split(" ")).map(w -> w).collect(Collectors.toList());
        words.removeIf(s -> Character.isLowerCase(s.charAt(0)));
        System.out.println(words.size());
        System.out.println(String.join("\n", words));
    }
}
