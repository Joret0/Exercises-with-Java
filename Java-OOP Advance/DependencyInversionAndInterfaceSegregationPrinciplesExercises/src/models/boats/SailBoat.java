package models.boats;

import interfaces.IRace;
import utilities.Constants;

public class SailBoat extends BaseBoat{
    private int sailEfficiency;

    public SailBoat(String model, int weight, int sailEfficiency) {
        super(model, weight);
        this.setSailEfficiency(sailEfficiency);
    }

    private int getSailEfficiency() {
        return sailEfficiency;
    }

    private void setSailEfficiency(int sailEfficiency) {
        if (sailEfficiency < 1 || sailEfficiency > 100) {
            throw new IllegalArgumentException(Constants.IncorrectSailEfficiencyMessage);
        }
        this.sailEfficiency = sailEfficiency;
    }

    @Override
    public double CalculateRaceSpeed(IRace race) {
        return race.getWindSpeed() * (this.getSailEfficiency() / 100.0) - super.getWeight() + (race.getOceanCurrentSpeed() / 2.0);
    }

    @Override
    public boolean hasEngine() {
        return false;
    }
}
