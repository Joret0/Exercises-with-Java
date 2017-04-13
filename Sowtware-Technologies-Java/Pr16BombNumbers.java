import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Pr16BombNumbers {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> numbers = Arrays.stream(reader.readLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> bomb = Arrays.stream(reader.readLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i).equals(bomb.get(0))) {
                for (int j = 1; j <= bomb.get(1); j++) {
                    if (i - j < 0) {
                        break;
                    } else {
                        numbers.set(i - j, 0);
                    }
                }
                for (int j = 1; j <= bomb.get(1); j++) {
                    if (i + j > numbers.size() - 1) {
                        break;
                    } else {
                        numbers.set(i + j, 0);
                    }
                }
                numbers.set(i, 0);
            }
        }
        int sum = numbers.stream().mapToInt(Integer::intValue).sum();
        System.out.println(sum);
    }
}
