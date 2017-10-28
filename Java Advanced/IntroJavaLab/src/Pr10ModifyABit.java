import java.util.Scanner;

public class Pr10ModifyABit {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int p = scanner.nextInt();
        int v = scanner.nextInt();
        int result = 0;

        if (v == 0) {
            int mask = ~(1 << p);
            result = n & mask;
        } else if (v == 1) {
            int mask = 1 << p;
            result = n | mask;
        }

        System.out.println(result);
    }
}
