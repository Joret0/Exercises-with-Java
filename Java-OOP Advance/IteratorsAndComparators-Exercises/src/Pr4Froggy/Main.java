package Pr4Froggy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String[] line = reader.readLine().replace(",", "").split("\\s+");
            if (line[0].equals("END")) {
                Controller.getLake().print();
                break;
            }
            Controller.getLake().add(line);
        }
    }
}
