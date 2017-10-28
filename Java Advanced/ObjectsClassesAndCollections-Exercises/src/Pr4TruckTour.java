import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Pr4TruckTour {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        Deque<Station> queue = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            String[] input = bufferedReader.readLine().split("\\s+");
            Station station = new Station(Integer.parseInt(input[0]), Integer.parseInt(input[1]));
            queue.add(station);
        }
        getFirstIndex(queue);
    }

    private static void getFirstIndex(Deque<Station> queue) {
        int index = 0;
        while (true) {
            int liters = 0;
            boolean isCycle = true;
            for (Station station : queue) {
                liters += station.liters;
                liters -= station.distanceToNext;
                if (liters < 0) {
                    isCycle = false;
                    break;
                }
            }
            if (isCycle) {
                System.out.println(index);
                break;
            }
            queue.add(queue.pop());
            index++;
        }
    }

    static class Station {
        int liters;
        int distanceToNext;

        Station(int liters, int distanceToNext) {
            this.liters = liters;
            this.distanceToNext = distanceToNext;
        }
    }
}
