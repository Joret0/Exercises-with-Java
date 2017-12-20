package pr04_WorkForce.modules;

public class PartTimeEmployee extends EmployeeImpl{
    private static final int DEFAULT_HOURS_WORK = 20;

    public PartTimeEmployee(String name) {
        super(name);
        this.setHoursPerWeek(DEFAULT_HOURS_WORK);
    }
}
