package models.boats;

import interfaces.IEngine;
import interfaces.IRace;

public class PowerBoat extends BaseBoat{
    private IEngine[] engines;

    public PowerBoat(String model, int weight, IEngine... engines) {
        super(model, weight);
        this.setEngines(engines);
    }

    private void setEngines(IEngine[] engines) {
        this.engines = engines;
    }

    @Override
    public double CalculateRaceSpeed(IRace race) {
        int firstEngineOutput = engines[0].getOutput();
        int secondEngineOutput = engines[1].getOutput();

        return (firstEngineOutput + secondEngineOutput) - super.getWeight() + (race.getOceanCurrentSpeed() / 5.0);
    }

    @Override
    public boolean hasEngine() {
        return true;
    }
}
