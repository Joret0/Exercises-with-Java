import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Pr9TheStockSpanProblem {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        int[] arrayInt = new int[n];
        for (int i = 0; i < n; i++) {
            arrayInt[i] = Integer.parseInt(bufferedReader.readLine());
        }
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(0);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(1).append("\n");
        for (int i = 1; i < arrayInt.length; i++) {
            while (!stack.isEmpty() && arrayInt[stack.peek()] <= arrayInt[i]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                stringBuilder.append(i - stack.peek()).append("\n");
            } else {
                stringBuilder.append(i + 1).append("\n");
            }
            stack.push(i);
        }
        System.out.println(stringBuilder.toString());
    }
}
