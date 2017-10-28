import java.util.Scanner;

public class Pr9ExtractBitFromInteger {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int first = scanner.nextInt();
        int second = scanner.nextInt();
        int mask = first >> second;
        int bit = mask & 1;
        System.out.println(bit);
    }
}
