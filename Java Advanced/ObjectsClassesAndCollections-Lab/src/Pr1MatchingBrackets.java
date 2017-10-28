import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Pr1MatchingBrackets {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String line = bufferedReader.readLine();
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < line.length(); i++) {
            char current = line.charAt(i);
            if (current == '(') {
                stack.push(i);
            } else if (current == ')') {
                int stackIndex = stack.pop();
                String subString = line.substring(stackIndex, i + 1);
                System.out.println(subString);
            }
        }
    }
}
