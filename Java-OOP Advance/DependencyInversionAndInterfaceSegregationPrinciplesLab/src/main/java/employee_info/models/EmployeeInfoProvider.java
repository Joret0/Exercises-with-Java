package employee_info.models;

import employee_info.interfaces.Database;
import employee_info.interfaces.Human;
import employee_info.interfaces.InfoProvider;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeeInfoProvider implements InfoProvider{
    private Database database;

    public EmployeeInfoProvider(Database database) {
        this.database = database;
    }

    @Override
    public List<Human> getByName() {
        return this.database.readEmployees().stream()
                .sorted(Comparator.comparing(Human::getName))
                .collect(Collectors.toList());
    }

    @Override
    public Iterable<Human> getBySalary() {
        return this.database.readEmployees().stream()
                .sorted(Comparator.comparing(Human::getSalary))
                .collect(Collectors.toList());
    }
}
