package Pr1ListyIterator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String[] line = reader.readLine().split("\\s+");
            if ("END".equals(line[0])) {
                break;
            }
            switch (line[0]) {
                case "Create":
                    Controller.getListyIterator().create(Arrays.copyOfRange(line, 1, line.length));
                    break;
                case "Move":
                    System.out.println(Controller.getListyIterator().move());
                    break;
                case "HasNext":
                    System.out.println(Controller.getListyIterator().hasNext());
                    break;
                case "Print":
                    Controller.getListyIterator().print();
                    break;
                case "PrintAll":
                    Controller.getListyIterator().printAll();
                    break;
            }
        }
    }
}
