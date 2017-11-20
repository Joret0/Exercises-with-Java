package Pr8MilitaryElite.modules;

import Pr8MilitaryElite.interfaces.Job;

public class Mission implements Job{

    private String codeName;
    private String stateOfMission;

    public Mission(String codeName, String stateOfMission) {
        this.codeName = codeName;
        this.setStateOfMission(stateOfMission);
    }

    public void setStateOfMission(String stateOfMission) {
        if (!stateOfMission.equals("inProgress") && !stateOfMission.equals("Finished")) {
            throw new IllegalArgumentException("invalid mission state");
        }
        this.stateOfMission = stateOfMission;
    }

    @Override
    public String toString() {
        return String.format("Code Name: %s State: %s", this.codeName, this.stateOfMission);
    }

    @Override
    public String name() {
        return this.stateOfMission;
    }
}
