import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class Pr12MatrixOfPalindromes {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> input = Arrays.stream(reader.readLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        char[][] matrix = new char[0][1];
        char a = 'a';
        char b = 'a';

        for (int rows = 0; rows < input.get(0); rows++) {
            for (int cols = 0; cols < input.get(1); cols++) {
                System.out.print(a);
                System.out.print(b);
                System.out.print(a);
                System.out.print(" ");
                b++;
            }
            System.out.println();
            a++;
            b = a;
        }
    }
}
