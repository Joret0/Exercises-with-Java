package Tuple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().split("\\s+");
        String name = String.format("%s %s", input[0], input[1]);
        Tuple<String, String> tuple = new Tuple<String, String>(name, input[2]);
        System.out.println(tuple);
        input = reader.readLine().split("\\s+");
        Tuple<String, Integer> tuple2 = new Tuple<String, Integer>(input[0], Integer.parseInt(input[1]));
        System.out.println(tuple2);
        input = reader.readLine().split("\\s+");
        Tuple<Integer, Double> tuple3 = new Tuple<Integer, Double>(Integer.parseInt(input[0]), Double.parseDouble(input[1]));
        System.out.println(tuple3);
    }
}
