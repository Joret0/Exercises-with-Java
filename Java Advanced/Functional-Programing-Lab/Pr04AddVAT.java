import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class Pr04AddVAT {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Double> numbers = Arrays.stream(reader.readLine().split(", ")).map(n -> Double.valueOf(n.trim())).collect(Collectors.toList());
        UnaryOperator<Double> vat = d -> d * 1.20;
        System.out.println("Prices with VAT:");
        numbers.forEach(n -> System.out.printf("%.2f\n", vat.apply(n)));
    }
}
