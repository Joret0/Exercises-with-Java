package Pr4.FirstAndReserveTeam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Person> persons = new ArrayList<>();
        int n = Integer.parseInt(reader.readLine());
        for (int i = 0; i < n; i++) {
            String[] input = reader.readLine().split("\\s+");
            String firstName = input[0];
            String lastName = input[1];
            Integer age = Integer.parseInt(input[2]);
            Double salary = Double.parseDouble(input[3]);
            try {
                Person person = new Person(firstName, lastName, age, salary);
                persons.add(person);
            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
            }
        }
        Team team = new Team("Manchester");
        for (Person person : persons) {
            team.addPlayer(person);
        }
        System.out.println("First team have " + team.getFirstTeamPlayers().size() + " players");
        System.out.println("Reserve team have " + team.getReverseTeamPlayers().size() + " players");
    }
}
