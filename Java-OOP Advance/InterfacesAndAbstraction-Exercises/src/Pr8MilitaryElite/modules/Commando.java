package Pr8MilitaryElite.modules;

import Pr8MilitaryElite.interfaces.Job;

import java.util.Set;

public class Commando extends SpecialisedSoldier{

    private Set<Job> missions;

    public Commando(String id, String firstName, String lastName, double salary, String corps, Set<Job> missions) {
        super(id, firstName, lastName, salary, corps);
        this.missions = missions;
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
    public String getCorps() {
        return super.getCorps();
    }

    @Override
    public void addJob(Job job) {
        this.missions.add(job);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("Name: %s %s Id: %s Salary: %.2f%nCorps: %s%nMissions:%n",
                super.getFirstName(), super.getLastName(), super.getId(), super.getSalary(), super.getCorps()));
        if (this.missions.size() > 0) {
            for (Job mission : this.missions) {
                if (mission.name().equals("inProgress")) {
                    builder.append("  ");
                    builder.append(mission.toString());
                    builder.append("\n");
                }
            }
        }
        return builder.toString();
    }
}
