import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Pr9ByteParty {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(bufferedReader.readLine());
        int[] numbers = new int[a];
        for (int i = 0; i < a; i++) {
            int b = Integer.parseInt(bufferedReader.readLine());
            numbers[i] = b;
        }
        while (true) {
            String[] command = bufferedReader.readLine().split("\\s+");
            if (command[0].equals("party")) {
                for (int number : numbers) {
                    System.out.println(number);
                }
                break;
            }
            int action = Integer.parseInt(command[0]);
            int position = Integer.parseInt(command[1]);

            switch (action) {
                case -1:
                    for (int i = 0; i < numbers.length; i++) {
                        numbers[i] = numbers[i] ^ (1 << position);
                    }
                    break;
                case 0:
                    int mask = ~(1 << position);
                    for (int i = 0; i < numbers.length; i++) {
                        numbers[i] = numbers[i] & mask;
                    }
                    break;
                case 1:
                    int mask2 = 1 << position;
                    for (int i = 0; i < numbers.length; i++) {
                        numbers[i] = numbers[i] | mask2;
                    }
                    break;
                default:
                    break;
            }
        }
    }
}
