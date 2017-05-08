package Pr11.CatLady;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Cat> catList = new ArrayList<>();

        String input = reader.readLine();

        while (!input.equals("End")) {
            String[] info = input.split("\\s+");
            String catBreed = info[0];
            String catName = info[1];
            String catSpecific = info[2];
            Cat cat = new Cat(catName, catBreed, catSpecific);
            catList.add(cat);
            input = reader.readLine();
        }
        String name = reader.readLine();

        for (Cat cat : catList) {
            if (cat.getName().equals(name)) {
                System.out.printf("%s %s %s%n", cat.getBreed(), cat.getName(), cat.getCatSpecific());
                break;
            }
        }
    }
}
