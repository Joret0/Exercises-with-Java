import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.stream.IntStream;

public class Pr3MathPotato {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] line = bufferedReader.readLine().split("\\s+");
        int n = Integer.parseInt(bufferedReader.readLine());
        Deque<String> queue = new ArrayDeque<>();
        for (int i = 0; i < line.length; i++) {
            queue.add(line[i]);
        }
        int cycle = 1;
        while (queue.size() > 1) {
            for (int i = 1; i <= n; i++) {
                if (i % n == 0) {
                    if (!isPrime(cycle)) {
                        System.out.println("Removed " + queue.remove());
                    } else {
                        System.out.println("Prime " + queue.element());
                    }
                } else {
                    queue.add(queue.poll());
                }
            }
            cycle++;
        }
        System.out.println("Last is " + queue.remove());
    }

    private static boolean isPrime(int number) {
        return number > 1 && IntStream.rangeClosed(2, (int) Math.sqrt(number)).noneMatch(i -> number % i == 0);
    }
}
