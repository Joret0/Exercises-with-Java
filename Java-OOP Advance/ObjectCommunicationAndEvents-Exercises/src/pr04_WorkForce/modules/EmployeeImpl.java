package pr04_WorkForce.modules;

import pr04_WorkForce.interfaces.Employee;

public class EmployeeImpl implements Employee{
    private String name;
    private int hoursPerWeek;

    public EmployeeImpl(String name) {
        this.name = name;
        this.hoursPerWeek = 0;
    }

    @Override
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int getHoursPerWeek() {
        return this.hoursPerWeek;
    }

    public void setHoursPerWeek(int hoursPerWeek) {
        this.hoursPerWeek = hoursPerWeek;
    }
}
