import java.util.Scanner;

public class Pr2AverageOfThreeNumbers {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        double first = scanner.nextDouble();
        double second = scanner.nextDouble();
        double third = scanner.nextDouble();
        double average = (first + second + third) / 3;
        System.out.printf("%.2f", average);
    }
}
