package GenericBox;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        int n = Integer.parseInt(reader.readLine());
        //readAsString(n); //task 1
        //readAsInteger(n); //task 2
        //swapStringElements(n); //task 3
        //swapIntegersElements(n); //task 4
        //genericCountMethodString(n); //task 5
        genericCountMethodDouble(n);

    }
    //01. Generic Box
    private static void readAsString(int n) throws IOException {
        for (int i = 0; i < n; i++) {
            String input = reader.readLine();
            Box box = new Box<>(input);
            System.out.println(box);
        }
    }
    //02. Generic Box of Integer
    private static void readAsInteger(int n) throws IOException {
        for (int i = 0; i < n; i++) {
            int number = Integer.parseInt(reader.readLine());
            Box box = new Box<>(number);
            System.out.println(box);
        }
    }
    //03. Generic Swap Method String
    private static void swapStringElements(int n) throws IOException {
        List<Box> boxes = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String line = reader.readLine();
            boxes.add(new Box<>(line));
        }
        int[] numbers = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        Box.swap(boxes, numbers[0], numbers[1]);
        print(boxes);
    }

    private static void print(List<Box> boxes) {
        for (Box box : boxes) {
            System.out.println(box);
        }
    }
    //04. Generic Swap Method Integer
    private static void swapIntegersElements(int n) throws IOException {
        List<Box> boxes = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int number = Integer.parseInt(reader.readLine());
            boxes.add(new Box<>(number));
        }
        int[] numbers = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        Box.swap(boxes, numbers[0], numbers[1]);
        print(boxes);
    }
    //05. Generic Count Method String
    private static void genericCountMethodString(int n) throws IOException {
        List<String> strings = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String line = reader.readLine();
            strings.add(line);
        }
        System.out.println(Box.countGreaterValues(strings, reader.readLine()));
    }
    //06. Generic Count Method Double
    private static void genericCountMethodDouble(int n) throws IOException {
        List<Double> doubles = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            double number = Double.parseDouble(reader.readLine());
            doubles.add(number);
        }
        System.out.println(Box.countGreaterValues(doubles, Double.parseDouble(reader.readLine())));
    }
}
