package Pr5BorderControl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        City city = new City(new ArrayList<>());
        while (true) {
            String[] input = reader.readLine().split("\\s+");
            if ("End".equals(input[0])) {
                break;
            }
            Inhabitable inhabit = Factory.createInhabitant(input);
            city.addInhabit(inhabit);
        }
        String fakeIds = reader.readLine();
        city.printFakeId(fakeIds);
    }
}
