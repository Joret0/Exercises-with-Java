import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Pr1BitFlipper {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BigInteger num = new BigInteger(bufferedReader.readLine());
        BigInteger seven = new BigInteger("7");
        BigInteger zero = new BigInteger("0");
        for (int i = 0; i <= 61; i++) {
            int n = 61 - i;
            BigInteger current = num.shiftRight(n).and(seven);
            if (current.equals(seven) || current.equals(zero)) {
                num = num.xor(seven.shiftLeft(n));
                i += 2;
            }
        }
        System.out.println(num);
    }
}
