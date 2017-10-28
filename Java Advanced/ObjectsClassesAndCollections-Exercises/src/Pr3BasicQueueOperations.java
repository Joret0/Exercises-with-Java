import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Pr3BasicQueueOperations {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        Deque<Integer> queue = new ArrayDeque<>();
        String[] ids = bufferedReader.readLine().split("\\s+");
        int n = Integer.parseInt(ids[0]);
        int s = Integer.parseInt(ids[1]);
        int x = Integer.parseInt(ids[2]);
        String[] numbers = bufferedReader.readLine().split("\\s+");
        for (int i = 0; i < n; i++) {
            queue.add(Integer.parseInt(numbers[i]));
        }
        for (int i = 0; i < s; i++) {
            queue.poll();
        }
        if (queue.isEmpty()) {
            System.out.println(0);
        } else {
            if (queue.contains(x)) {
                System.out.println(true);
            } else {
                System.out.println(queue.stream().min(Integer::compareTo).get());
            }
        }
    }
}
