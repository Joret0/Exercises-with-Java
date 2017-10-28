import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Pr7CharacterMultiplier {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = bufferedReader.readLine().split("\\s+");
        String firstString = input[0];
        String secondString = input[1];
        int sum = 0;
        if (firstString.length() < secondString.length()) {
            sum = getSumOfMultiplyCharacters(firstString, secondString, sum);
            for (int i = firstString.length(); i < secondString.length(); i++) {
                int n = 0;
                if (Character.isDigit(secondString.charAt(i))) {
                    n = Character.getNumericValue(secondString.charAt(i));
                } else {
                    n = secondString.charAt(i);
                }
                sum += n;
            }
        } else if (secondString.length() < firstString.length()) {
            sum = getSumOfMultiplyCharacters(firstString, secondString, sum);
            for (int i = secondString.length(); i < firstString.length(); i++) {
                int n = 0;
                if (Character.isDigit(firstString.charAt(i))) {
                    n = Character.getNumericValue(firstString.charAt(i));
                } else {
                    n = firstString.charAt(i);
                }
                sum += n;
            }
        } else {
            sum = getSumOfMultiplyCharacters(firstString, secondString, sum);
        }

        System.out.println(sum);
    }

    private static int getSumOfMultiplyCharacters(String firstString, String secondString, int sum) {
        for (int i = 0; i < secondString.length(); i++) {
            int a;
            int b;
            if (Character.isDigit(firstString.charAt(i))) {
                a = Character.getNumericValue(firstString.charAt(i));
            } else {
                a = firstString.charAt(i);
            }
            if (Character.isDigit(secondString.charAt(i))) {
                b = Character.getNumericValue(secondString.charAt(i));
            } else {
                b = secondString.charAt(i);
            }
            sum += a * b;
        }
        return sum;
    }
}
