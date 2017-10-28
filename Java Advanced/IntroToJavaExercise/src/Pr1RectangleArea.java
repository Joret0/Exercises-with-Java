import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Pr1RectangleArea {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        double[] input = Arrays.stream(bufferedReader.readLine().split("\\s+")).mapToDouble(Double::parseDouble).toArray();
        double a = input[0];
        double b = input[1];

        double area = a * b;

        System.out.printf("%.2f%n", area);
    }
}
