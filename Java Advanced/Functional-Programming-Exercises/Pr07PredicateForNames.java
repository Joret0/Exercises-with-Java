import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.Predicate;

public class Pr07PredicateForNames {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(reader.readLine());
        String[] names = reader.readLine().split("\\s+");
        Predicate<String> predicate = i -> i.length() <= length;
        Arrays.stream(names).filter(predicate).forEach(System.out::println);
        reader.close();
    }
}
