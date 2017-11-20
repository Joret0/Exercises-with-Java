package Pr8MilitaryElite.modules;

import Pr8MilitaryElite.interfaces.SoldierImpl;

public class Spy extends Soldier implements SoldierImpl{

    private String codeNumber;

    public Spy(String id, String firstName, String lastName, String codeNumber) {
        super(id, firstName, lastName);
        this.codeNumber = codeNumber;
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
    public String toString() {
        return String.format("Name: %s %s Id: %s%nCode Number: %s",
                super.getFirstName(), super.getLastName(), super.getId(), this.codeNumber);
    }
}
