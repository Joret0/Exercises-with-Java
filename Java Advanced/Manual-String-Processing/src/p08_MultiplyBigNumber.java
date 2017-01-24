import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p08_MultiplyBigNumber {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String number = reader.readLine();
        String multiplier = reader.readLine();
        String temp = multiply(number, multiplier);
        StringBuilder deleteZeroBuilder = new StringBuilder(temp);

        while (deleteZeroBuilder.charAt(0) == '0'){
            if (deleteZeroBuilder.length() == 1){
                break;
            }
            deleteZeroBuilder.deleteCharAt(0);
        }
        String result = deleteZeroBuilder.toString();
        System.out.println(result);
    }

    public static String multiply(String num, String multiplier){
        StringBuilder builder = new StringBuilder();
        int numIndex = num.length() - 1;
        int carryNum = 0;
        int multi = Integer.parseInt(multiplier);

        while (numIndex >= 0 || carryNum != 0){
            int digit = numIndex < 0 ? 0 : Integer.parseInt(Character.toString(num.charAt(numIndex)));
            int result = (digit * multi) + carryNum;
            if (result > 9){
                carryNum = result / 10;
                result = result % 10;
            } else {
                carryNum = 0;
            }
            builder.append(result);
            numIndex--;
        }
        return builder.reverse().toString();
    }
}
