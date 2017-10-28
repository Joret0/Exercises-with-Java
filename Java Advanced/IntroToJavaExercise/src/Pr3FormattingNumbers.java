import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Pr3FormattingNumbers {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] input = bufferedReader.readLine().split("\\s+");
        int a = Integer.parseInt(input[0]);
        double b = Double.parseDouble(input[1]);
        double c = Double.parseDouble(input[2]);
        String aInBinary = String.format("%10s", Integer.toBinaryString(a)).replace(' ', '0');

        String lane = String.format("|%-10s|%s|%10.2f|%-10.3f|",Integer.toHexString(a).toUpperCase(), aInBinary, b, c);
        System.out.println(lane);
    }
}
