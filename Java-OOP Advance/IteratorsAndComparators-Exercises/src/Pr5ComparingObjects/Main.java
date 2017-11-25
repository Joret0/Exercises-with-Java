package Pr5ComparingObjects;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Person> personList = new ArrayList<>();
        while (true) {
            String[] line = reader.readLine().split("\\s+");
            if ("END".equals(line[0])) {
                break;
            }
            Person person = new Person(line[0], Integer.parseInt(line[1]), line[2]);
            personList.add(person);
        }
        Person p = personList.get(Integer.parseInt(reader.readLine()) - 1);
        int totalPeople = personList.size();
        int equalPeople = (int) personList.stream().filter(x -> x.compareTo(p) == 0).count();
        int notEqualPeople = totalPeople - equalPeople;
        if (equalPeople > 1) {
            System.out.printf("%d %d %d%n", equalPeople, notEqualPeople, totalPeople);
        } else {
            System.out.println("No matches");
        }
    }
}

