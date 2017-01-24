import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.InterruptedIOException;

public class p03_FormattingNumbers {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] array = reader.readLine().split("[\\t\\s]+");
        int firstNumber = Integer.parseInt(array[0]);
        double secondNumber = Double.parseDouble(array[1]);
        double thirdNumber = Double.parseDouble(array[2]);
        String aBinary = Integer.toString(firstNumber, 2);
        if (aBinary.length() > 10){
            aBinary = aBinary.substring(0, 10);
        }
        System.out.printf("|%-10X|%010d|%10.2f|%-10.3f|", firstNumber, Integer.parseInt(aBinary), secondNumber, thirdNumber);
    }
}
