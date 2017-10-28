import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Pr1BasicStackOperations {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        Deque<Integer> stack = new ArrayDeque<>();
        String[] input = bufferedReader.readLine().split("\\s+");
        int numbersToPush = Integer.parseInt(input[0]);
        int numbersToPop = Integer.parseInt(input[1]);
        int numberToExistInStack = Integer.parseInt(input[2]);
        String[] numbersInfo = bufferedReader.readLine().split("\\s+");
        for (int i = 0; i < numbersToPush; i++) {
            stack.push(Integer.parseInt(numbersInfo[i]));
        }
        for (int i = 0; i < numbersToPop; i++) {
            stack.pop();
        }
        if (!stack.isEmpty()) {
            if (stack.contains(numberToExistInStack)) {
                System.out.println(true);
            } else {
                int smallestElementInStack = stack.stream().min(Integer::compareTo).get();
                System.out.println(smallestElementInStack);
            }
        } else {
            System.out.println(0);
        }
    }
}
