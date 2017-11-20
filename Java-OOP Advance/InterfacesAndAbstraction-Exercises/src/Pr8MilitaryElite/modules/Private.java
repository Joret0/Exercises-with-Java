package Pr8MilitaryElite.modules;

import Pr8MilitaryElite.interfaces.PrivateImpl;

public class Private extends Soldier implements PrivateImpl{

    private double salary;

    public Private(String id, String firstName, String lastName, double salary) {
        super(id, firstName, lastName);
        this.salary = salary;
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
        return this.salary;
    }

    @Override
    public String toString() {
        return String.format("Name: %s %s Id: %s Salary: %.2f", super.getFirstName(), super.getLastName(), super.getId(), this.getSalary());
    }
}
