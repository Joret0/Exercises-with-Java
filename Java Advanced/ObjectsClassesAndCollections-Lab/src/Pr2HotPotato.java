import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Pr2HotPotato {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] line = bufferedReader.readLine().split("\\s+");
        int n = Integer.parseInt(bufferedReader.readLine());
        Deque<String> queue = new ArrayDeque<>();
        for (int i = 0; i < line.length; i++) {
            queue.add(line[i]);
        }
        while (queue.size() > 1) {
            for (int i = 1; i <= n; i++) {
                if (i % n == 0) {
                    System.out.println("Removed " + queue.remove());
                } else {
                    queue.add(queue.poll());
                }
            }
        }
        System.out.println("Last is " + queue.remove());
    }
}
