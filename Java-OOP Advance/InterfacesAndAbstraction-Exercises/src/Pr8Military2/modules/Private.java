package Pr8Military2.modules;

import Pr8Military2.interfaces.IPrivate;

public class Private extends Soldier implements IPrivate{

    private double salary;

    public Private(int id, String firstName, String lastName, double salary) {
        super(id, firstName, lastName);
        this.salary = salary;
    }

    @Override
    public double getSalary() {
        return this.salary;
    }

    @Override
    public String toString() {
        return super.toString().concat(String.format(" Salary: %.2f", this.getSalary()));
    }
}
