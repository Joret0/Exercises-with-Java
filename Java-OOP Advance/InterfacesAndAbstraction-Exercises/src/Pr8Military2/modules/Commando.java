package Pr8Military2.modules;

import Pr8Military2.interfaces.ICommando;

import java.util.ArrayList;
import java.util.List;

public class Commando extends SpecialisedSoldier implements ICommando{
    private List<Mission> missions;

    public Commando(int id, String firstName, String lastName, double salary, String corps) {
        super(id, firstName, lastName, salary, corps);
        this.missions = new ArrayList<>();
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder(super.toString());
        builder.append(System.lineSeparator());
        builder.append("Missions:");
        for (Mission mission : missions) {
            builder.append(System.lineSeparator());
            builder.append("  ").append(mission);
        }
        return builder.toString();
    }

    @Override
    public void addMission(Mission mission) {
        this.missions.add(mission);
    }
}
