import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p12_CharacterMultiplier {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        String[] splitStr = input.split("\\s+");

        String firstWord;
        String secondWord;
        if (splitStr[0].length() > splitStr[1].length()){
            firstWord = splitStr[0];
            secondWord = splitStr[1];
        } else {
            firstWord = splitStr[1];
            secondWord = splitStr[0];
        }
        long sum = getSum(firstWord, secondWord);
        System.out.println(sum);
    }

    public static long getSum(String firstWord, String secondWord){
        long sum = 0;
        for (int i = 0; i < firstWord.length(); i++) {
            if (i < secondWord.length()){
                sum += (firstWord.charAt(i) * secondWord.charAt(i));
            } else {
                sum += (firstWord.charAt(i));
            }
        }
        return sum;
    }
}
