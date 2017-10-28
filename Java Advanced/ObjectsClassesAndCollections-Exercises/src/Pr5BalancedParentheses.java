import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Pr5BalancedParentheses {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        char[] line = bufferedReader.readLine().toCharArray();
        Deque<Character> stack = new ArrayDeque<>();
        boolean b = true;
        for (char c : line) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else if (c == ')' || c == '}' || c == ']') {
                if (!stack.isEmpty()) {
                    Character pop = stack.pop();
                    if (c == ')' && pop != '(') {
                        b = false;
                        break;
                    } else if (c == '}' && pop != '{') {
                        b = false;
                        break;
                    } else if (c == ']' && pop != '[') {
                        b = false;
                        break;
                    }
                } else {
                    b = false;
                    break;
                }
            }
        }
        if (b) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
