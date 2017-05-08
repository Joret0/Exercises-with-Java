package Pr3.OpinionPoll;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        List<Person> personList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] info = reader.readLine().split("\\s+");
            String name = info[0];
            int age = Integer.parseInt(info[1]);
            Person person = new Person(name, age);
            personList.add(person);
        }
        personList.sort(Comparator.comparing(Person::getName));

        for (Person person : personList) {
            if (person.getAge() > 30) {
                System.out.printf("%s - %d%n", person.getName(), person.getAge());
            }
        }
    }
}
