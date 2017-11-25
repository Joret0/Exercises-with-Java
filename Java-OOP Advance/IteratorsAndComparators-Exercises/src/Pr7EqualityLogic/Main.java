package Pr7EqualityLogic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Set<Person> treeSet = new TreeSet<>();
        Set<Person> hashSet = new HashSet<>();
        int n = Integer.parseInt(reader.readLine());
        for (int i = 0; i < n; i++) {
            String[] line = reader.readLine().split("\\s+");
            Person person = new Person(line[0], Integer.parseInt(line[1]));
            treeSet.add(person);
            hashSet.add(person);
        }
        System.out.println(treeSet.size());
        System.out.println(hashSet.size());
    }
}
