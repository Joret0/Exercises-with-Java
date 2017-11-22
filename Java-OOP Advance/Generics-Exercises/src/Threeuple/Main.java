package Threeuple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] line = reader.readLine().split("\\s+");
        String name = String.format("%s %s", line[0], line[1]);
        Threeuple<String, String, String> threeuple = new Threeuple<String, String, String>(name, line[2], line[3]);
        System.out.println(threeuple);
        line = reader.readLine().split("\\s+");
        Threeuple<String, Integer, Boolean> threeuple2 = new Threeuple<String, Integer, Boolean>(line[0], Integer.parseInt(line[1]), line[2].equals("drunk"));
        System.out.println(threeuple2);
        line = reader.readLine().split("\\s+");
        Threeuple<String, Double, String> threeuple3 = new Threeuple<String, Double, String>(line[0], Double.parseDouble(line[1]), line[2]);
        System.out.println(threeuple3);
    }
}
