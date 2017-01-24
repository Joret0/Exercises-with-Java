import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class p05_ConvertFromBaseNToBase10 {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] array = reader.readLine().split("\\s+");
        BigInteger base = new BigInteger(array[0]);
        BigInteger num = new BigInteger(array[1]);
        BigInteger result = BigInteger.ZERO;
        int index = 0;

        while (num.compareTo(BigInteger.ZERO) == 1){
            result = result.add(num.remainder(BigInteger.valueOf(10)).multiply(base.pow(index)));
            num = num.divide(BigInteger.valueOf(10));
            index++;
        }
        System.out.println(result);
    }
}
