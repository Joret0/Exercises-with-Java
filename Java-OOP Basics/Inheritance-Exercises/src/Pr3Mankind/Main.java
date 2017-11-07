package Pr3Mankind;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String[] studentInfo = reader.readLine().split("\\s+");
            String firstName = studentInfo[0];
            String lastName = studentInfo[1];
            String facultyNumber = studentInfo[2];
            Student student = new Student(firstName, lastName, facultyNumber);
            String[] workerInfo = reader.readLine().split("\\s+");
            firstName = workerInfo[0];
            lastName = workerInfo[1];
            double weekSalary = Double.parseDouble(workerInfo[2]);
            double hoursPerDay = Double.parseDouble(workerInfo[3]);
            Worker worker = new Worker(firstName, lastName, weekSalary, hoursPerDay);
            System.out.println(student);
            System.out.println(worker);
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
