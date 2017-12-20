package pr02_KingsGambit.models;

import pr02_KingsGambit.interfaces.Killable;

public abstract class Unit implements Killable{
    private String name;
    protected boolean isDead;

    public Unit(String name) {
        this.name = name;
    }
    public String getName() {
        return this.name;
    }
}
