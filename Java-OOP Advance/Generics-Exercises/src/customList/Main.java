package customList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        CustomList<String> customList = new CustomList<>();
        while (true) {
            String[] input = reader.readLine().split("\\s+");
            if ("END".equals(input[0])) {
                break;
            }
            switch (input[0]) {
                case "Add":
                    customList.add(input[1]);
                    break;
                case "Remove":
                    customList.remove(Integer.parseInt(input[1]));
                    break;
                case "Contains":
                    System.out.println(customList.contains(input[1]));
                    break;
                case "Swap":
                    customList.swap(Integer.parseInt(input[1]), Integer.parseInt(input[2]));
                    break;
                case "Greater":
                    System.out.println(customList.countGreaterThan(input[1]));
                    break;
                case "Max":
                    System.out.println(customList.getMax());
                    break;
                case "Min":
                    System.out.println(customList.getMin());
                    break;
                case "Print":
                    System.out.println(customList);
                    break;
                case "Sort":
                    CustomSorterClass.sort(customList);
                    break;
            }
        }
    }
}
