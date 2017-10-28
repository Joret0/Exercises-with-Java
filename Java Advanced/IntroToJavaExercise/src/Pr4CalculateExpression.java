import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Pr4CalculateExpression {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = bufferedReader.readLine().split("\\s+");
        double a = Double.parseDouble(input[0]);
        double b = Double.parseDouble(input[1]);
        double c = Double.parseDouble(input[2]);
        double f1 = Math.pow((Math.pow(a, 2) + Math.pow(b, 2)) / (Math.pow(a, 2) - Math.pow(b, 2)), (a + b + c) / Math.sqrt(c));
        double f2 = Math.pow(Math.pow(a, 2) + Math.pow(b, 2) - Math.pow(c, 3), a - b);
        double differenceBetweenAbsoluteValues = Math.abs(((a + b + c) / 3) - ((f1 + f2) / 2) );

        System.out.printf("F1 result: %.2f; F2 result: %.2f; Diff: %.2f%n", f1, f2, differenceBetweenAbsoluteValues);
    }
}
