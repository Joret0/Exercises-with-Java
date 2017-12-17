package employee_info.models;

import employee_info.interfaces.Database;
import employee_info.interfaces.Human;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EmployeeDatabase implements Database{
    @Override
    public List<Human> readEmployees() {
        List<Human> employees = new ArrayList<>();
        Collections.addAll(employees, new Employee("Georgi", 20), new Employee("Pesho", 40));
        return employees;
    }
}
