import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Pr5Palindromes {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        char[] separators = new char[] {' ', '!', '.', ',', '\\', '/', '?'};
        List<String> text = Arrays.stream(bufferedReader.readLine()
                .split("[" + String.valueOf(separators) + "]"))
                .filter(x -> !x.equals(""))
                .collect(Collectors.toList());
        Set<String> palindromes = new TreeSet<>();

        for (int i = 0; i < text.size(); i++) {
            String reversedWord = new StringBuilder(text.get(i)).reverse().toString();
            if (text.get(i).equals(reversedWord)) {
                palindromes.add(text.get(i));
            }
        }
        System.out.println(palindromes);
    }
}
