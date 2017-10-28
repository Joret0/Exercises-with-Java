import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Pr3BitRoller {
    private static int SIZE = 19;

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BigInteger n = new BigInteger(bufferedReader.readLine());
        BigInteger one = new BigInteger("1");
        int index = Integer.parseInt(bufferedReader.readLine());
        int rolls = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i < rolls; i++) {
            BigInteger mostRightBit = n.and(one);
            n = n.shiftRight(1);
            mostRightBit = mostRightBit.shiftLeft(18);
            n = n.or(mostRightBit);

            if (index - 1 < 0) {
                n = n.andNot((one.shiftLeft(SIZE - 1)));
                n = n.or(one);
                continue;
            }
            BigInteger seventh = n.shiftRight(index - 1).and(one);
            BigInteger eight = n.shiftRight(index).and(one);

            n = n.andNot((one.shiftLeft(index - 1)));
            n = n.andNot((one.shiftLeft(index)));

            if (seventh.equals(one)) {
                n = n.or(one.shiftLeft(index));
            } else {
                n = n.andNot((one.shiftLeft(index)));
            }

            if (eight.equals(one)) {
                n = n.or(one.shiftLeft(index - 1));
            } else {
                n = n.andNot((one.shiftLeft(index - 1)));
            }
        }
        System.out.println(n);
    }
}
