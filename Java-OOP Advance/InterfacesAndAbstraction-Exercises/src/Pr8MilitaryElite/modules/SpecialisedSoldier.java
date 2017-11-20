package Pr8MilitaryElite.modules;

import Pr8MilitaryElite.interfaces.Job;
import Pr8MilitaryElite.interfaces.SpecialisedSoldierImpl;


public abstract class SpecialisedSoldier extends Private implements SpecialisedSoldierImpl{

    private String corps;

    public SpecialisedSoldier(String id, String firstName, String lastName, double salary, String corps) {
        super(id, firstName, lastName, salary);
        this.setCorps(corps);
    }

    public void setCorps(String corps) {
        if (!corps.equals("Airforces") && !corps.equals("Marines")) {
            throw new IllegalArgumentException("invalid corps");
        }
        this.corps = corps;
    }

    @Override
    public double getSalary() {
        return super.getSalary();
    }

    @Override
    public String getCorps() {
        return this.corps;
    }

    @Override
    public void addJob(Job job) {

    }
}
