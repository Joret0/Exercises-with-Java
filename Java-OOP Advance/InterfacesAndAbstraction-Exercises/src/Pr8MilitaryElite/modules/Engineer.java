package Pr8MilitaryElite.modules;

import Pr8MilitaryElite.interfaces.Job;

import java.util.Set;

public class Engineer extends SpecialisedSoldier{

    private Set<Job> repairs;

    public Engineer(String id, String firstName, String lastName, double salary, String corps, Set<Job> repairs) {
        super(id, firstName, lastName, salary, corps);
        this.repairs = repairs;
    }

    @Override
    public String getId() {
        return super.getId();
    }

    @Override
    public String getFirstName() {
        return super.getFirstName();
    }

    @Override
    public String getLastName() {
        return super.getLastName();
    }

    @Override
    public double getSalary() {
        return super.getSalary();
    }

    @Override
    public String getCorps() {
        return super.getCorps();
    }

    @Override
    public void addJob(Job repair) {
        this.repairs.add(repair);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("Name: %s %s Id: %s Salary: %.2f%nCorps: %s%nRepairs:%n",
                super.getFirstName(), super.getLastName(), super.getId(), super.getSalary(), super.getCorps()));

        if (this.repairs.size() > 0) {
            for (Job repair : this.repairs) {
                builder.append("  ");
                builder.append(repair.toString());
                builder.append("\n");
            }
        }
        return builder.toString();
    }
}
