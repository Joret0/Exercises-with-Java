package Pr6StrategyPattern;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Set<Person> nameSet = new TreeSet<>(new NameComparator());
        Set<Person> ageSet = new TreeSet<>(new AgeComparator());
        int n = Integer.parseInt(reader.readLine());
        for (int i = 0; i < n; i++) {
            String[] line = reader.readLine().split("\\s+");
            Person person = new Person(line[0], Integer.parseInt(line[1]));
            nameSet.add(person);
            ageSet.add(person);
        }
        for (Person person : nameSet) {
            System.out.println(person);
        }
        for (Person person : ageSet) {
            System.out.println(person);
        }
    }
}
