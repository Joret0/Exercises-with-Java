package Pr8MilitaryElite.modules;

import Pr8MilitaryElite.interfaces.SoldierImpl;

public abstract class Soldier implements SoldierImpl{

    private String id;
    private String firstName;
    private String lastName;

    Soldier(String id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public String getFirstName() {
        return this.firstName;
    }

    @Override
    public String getLastName() {
        return this.lastName;
    }
}
