package Pr3StackIterator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String[] line = reader.readLine().replace(",", "").split("\\s+");
            if (line[0].equals("END")) {
                Controller.getCustomStack().forEach(System.out::println);
                Controller.getCustomStack().forEach(System.out::println);
                break;
            }
            switch (line[0]) {
                case "Push":
                    String[] numbers = Arrays.copyOfRange(line, 1, line.length);
                    Controller.getCustomStack().push(numbers);
                    break;
                case "Pop":
                    Controller.getCustomStack().pop();
                    break;
            }
        }
    }
}
