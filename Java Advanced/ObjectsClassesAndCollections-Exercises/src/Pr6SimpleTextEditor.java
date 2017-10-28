import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;
import java.util.List;
import java.util.stream.Collectors;

public class Pr6SimpleTextEditor {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        Deque<Character> mainStack = new ArrayDeque<>();
        Deque<String> operationStack = new ArrayDeque<>();
        int n = Integer.parseInt(bufferedReader.readLine());
        for (int i = 0; i < n; i++) {
            String[] line = bufferedReader.readLine().split("\\s+");
            int type = Integer.parseInt(line[0]);
            switch (type) {
                case 1:
                    push(mainStack, operationStack, line[1], true);
                    break;
                case 2:
                    pop(mainStack, operationStack, Integer.parseInt(line[1]), true);
                    break;
                case 3:
                    int index = Integer.parseInt(line[1]);
                    List<Character> temp = mainStack.stream().collect(Collectors.toList());
                    Collections.reverse(temp);
                    System.out.println(temp.get(index - 1));
                    break;
                case 4:
                    String poll = operationStack.poll();
                    if (poll.charAt(0) == '1') {
                        pop(mainStack, operationStack, poll.substring(1).length(), false);
                    } else if (poll.charAt(0) == '2') {
                        push(mainStack, operationStack, poll.substring(1), false);
                    }
                    break;
            }
        }
    }

    private static void pop(Deque<Character> mainStack, Deque<String> operationStack, int count, boolean isAddToOperationStack) {
        StringBuilder stringBuilder = new StringBuilder();
        if (mainStack.size() >= count) {
            for (int j = 0; j < count; j++) {
                Character pop = mainStack.pop();
                stringBuilder.append(pop);
            }
            if (isAddToOperationStack) {
                operationStack.push(2 + stringBuilder.reverse().toString());
            }
        }
    }

    private static void push(Deque<Character> mainStack, Deque<String> operationStack, String s, boolean isAddToOperationStack) {
        for (Character character : s.toCharArray()) {
            mainStack.push(character);
        }
        if (isAddToOperationStack) {
            operationStack.push(1 + s);
        }
    }
}
