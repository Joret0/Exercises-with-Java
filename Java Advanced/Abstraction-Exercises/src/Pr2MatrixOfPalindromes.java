import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Pr2MatrixOfPalindromes {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = bufferedReader.readLine().split("\\s+");
        int r = Integer.parseInt(input[0]);
        int c = Integer.parseInt(input[1]);
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                String string = Character.toString((char) (i + 97)) + "" + Character.toString((char) (i + 97 + j)) + "" + Character.toString((char) (i + 97));
                System.out.printf("%s ", string);
            }
            System.out.println();
        }
    }
}
