package Pr8Military2.modules;

import Pr8Military2.interfaces.ISpecialisedSoldier;

public class SpecialisedSoldier extends Private implements ISpecialisedSoldier{
    private String corps;

    SpecialisedSoldier(int id, String firstName, String lastName, double salary, String corps) {
        super(id, firstName, lastName, salary);
        this.setCorps(corps);
    }

    private void setCorps(String corps) {
        if (!corps.equals("Airforces") && !corps.equals("Marines")) {
            throw new IllegalArgumentException("Invalid corps.");
        }
        this.corps = corps;
    }

    @Override
    public String getCorps() {
        return this.corps;
    }

    @Override
    public String toString() {
        return super.toString() + String.format("\nCorps: %s", this.corps);
    }
}
