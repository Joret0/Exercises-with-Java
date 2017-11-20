package Pr8Military2.modules;

import Pr8Military2.interfaces.IEngineer;

import java.util.ArrayList;
import java.util.List;

public class Engineer extends SpecialisedSoldier implements IEngineer{
    private List<Repair> repairs;

    public Engineer(int id, String firstName, String lastName, double salary, String corps) {
        super(id, firstName, lastName, salary, corps);
        this.repairs = new ArrayList<>();
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder(super.toString());
        builder.append(System.lineSeparator());
        builder.append("Repairs:");
        for (Repair repair : repairs) {
            builder.append(System.lineSeparator());
            builder.append("  ").append(repair);
        }
        return builder.toString();
    }

    @Override
    public void addRepair(Repair repair) {
        this.repairs.add(repair);
    }
}
