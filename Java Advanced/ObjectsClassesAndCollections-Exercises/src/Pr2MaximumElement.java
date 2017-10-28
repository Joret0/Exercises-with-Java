import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Pr2MaximumElement {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        Deque<Integer> stack = new ArrayDeque<>();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < n; i++) {
            String[] input = bufferedReader.readLine().split("\\s+");
            switch (input[0]) {
                case "1":
                    stack.push(Integer.parseInt(input[1]));
                    break;
                case "2":
                    stack.pop();
                    break;
                case "3":
                    stringBuilder.append(stack.stream().max(Integer::compareTo).get()).append("\n");
                    break;
            }
        }
        System.out.println(stringBuilder.toString());
    }
}
