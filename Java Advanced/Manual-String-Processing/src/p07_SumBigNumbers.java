import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p07_SumBigNumbers {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String num1 = reader.readLine();
        String num2 = reader.readLine();
        String temp = add(num1, num2);
        StringBuilder deleteZeroBuilder = new StringBuilder(temp);

        while (deleteZeroBuilder.charAt(0) == '0'){
            deleteZeroBuilder.deleteCharAt(0);
        }
        String result = deleteZeroBuilder.toString();
        System.out.println(result);
    }

    private static String add(String num1, String num2){
        StringBuilder builder = new StringBuilder();
        int first = num1.length() - 1;
        int second = num2.length() - 1;
        int carryNum = 0;

        while (first >= 0 || second >= 0 || carryNum != 0){
            int d1 = first < 0 ? 0 : Integer.parseInt(Character.toString(num1.charAt(first)));
            int d2 = second < 0 ? 0 : Integer.parseInt(Character.toString(num2.charAt(second)));

            int digit = d1 + d2 + carryNum;
            if (digit > 9){
                carryNum = 1;
                digit -= 10;
            } else {
                carryNum = 0;
            }
            builder.append(digit);
            first--;
            second--;
        }
        return builder.reverse().toString();
    }
}
