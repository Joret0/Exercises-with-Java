import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Pr1CalculateTriangleAreaMethod {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        double[] arrayDouble = Arrays.stream(bufferedReader.readLine().split("\\s+")).mapToDouble(Double::parseDouble).toArray();
        double area = getArea(arrayDouble);
        System.out.printf("Area = %.2f%n", area);
    }

    private static double getArea(double[] arrayDouble) {
        double base = arrayDouble[0];
        double height = arrayDouble[1];
        return (base * height) / 2;
    }
}
