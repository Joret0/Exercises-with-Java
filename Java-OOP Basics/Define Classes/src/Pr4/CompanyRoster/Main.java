package Pr4.CompanyRoster;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, List<Double>> departments = new HashMap<>();
        int n = Integer.parseInt(reader.readLine());
        ArrayList<Employee> employees = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] input = reader.readLine().split("\\s+");
            String name = input[0];
            double salary = Double.parseDouble(input[1]);
            String position = input[2];
            String department = input[3];
            String email = null;
            Integer age = null;

            if (input.length == 5) {
                if (input[4].contains("@")) {
                    email = input[4];
                } else {
                    age = Integer.parseInt(input[4]);
                }
            } else if (input.length == 6) {
                email = input[4];
                age = Integer.parseInt(input[5]);
            }

            Employee employee = new Employee(name, salary, position, department, email, age);

            if (!departments.containsKey(department)) {
                departments.put(department, new ArrayList<>());
            }
            departments.get(department).add(salary);
            employees.add(employee);
        }

        HashMap<String, Double> averages = new HashMap<>();

        departments.entrySet().stream().forEach(e -> {
            double average = e.getValue().stream().mapToDouble(i -> i).average().getAsDouble();
            averages.put(e.getKey(), average);
        });

        String highSalaryDepartment =
                Collections.max(averages.entrySet(), (entry1, entry2) -> entry1.getValue() > entry2.getValue() ? 1 : -1).getKey();

        System.out.printf("Highest Average Salary: %s%n", highSalaryDepartment);

        employees.stream()
                .filter(e -> e .getDepartment().equals(highSalaryDepartment))
                .sorted((e1, e2) -> Double.compare(e2.getSalary(), e1.getSalary()))
                .forEach(System.out::println);
    }
}

