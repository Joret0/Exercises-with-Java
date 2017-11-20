package Pr6BirthdayCelebrations;

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
            if (input[0].equals("End")) {
                break;
            }

            Inhabitable inhabitant = Factory.createInhabitant(input);
            city.addInhabit(inhabitant);
        }

        String year = reader.readLine();
        city.printYear(year);
    }
}
