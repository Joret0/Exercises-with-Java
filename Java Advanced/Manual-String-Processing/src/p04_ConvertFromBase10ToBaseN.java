import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class p04_ConvertFromBase10ToBaseN {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] array = reader.readLine().split(" ");
        BigInteger base = new BigInteger(array[0]);
        BigInteger num = new BigInteger(array[1]);
        StringBuilder result = new StringBuilder();

        while (num.compareTo(BigInteger.ZERO) == 1){
            result.append(num.remainder(base));
            num = num.divide(base);
        }
        System.out.println(result.reverse().toString());
    }
}
