package Pr8MilitaryElite.modules;

import Pr8MilitaryElite.interfaces.PrivateImpl;
import java.util.Comparator;
import java.util.List;

public class LeutenantGeneral extends Private implements PrivateImpl{

    private List<PrivateImpl> privates;

    public LeutenantGeneral(String id, String firstName, String lastName, double salary, List<PrivateImpl> privates) {
        super(id, firstName, lastName, salary);
        this.privates = privates;
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
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("Name: %s %s Id: %s Salary: %.2f%nPrivates:%n",
                this.getFirstName(), this.getLastName(), this.getId(), this.getSalary()));
        if (this.privates.size() > 0) {
            this.privates.sort(Comparator.comparing(PrivateImpl::getId).reversed());
            for (PrivateImpl aPrivate : this.privates) {
                builder.append("  ");
                builder.append(aPrivate.toString());
                builder.append("\n");
            }
        }
        return builder.toString();
    }
}
