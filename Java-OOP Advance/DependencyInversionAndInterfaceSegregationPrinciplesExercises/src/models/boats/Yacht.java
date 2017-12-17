package models.boats;

import interfaces.IEngine;
import interfaces.IRace;
import utilities.Validator;

public class Yacht extends BaseBoat{
    private IEngine engine;
    private int cargoWeight;

    public Yacht(String model, int weight, IEngine engine, int cargoWeight) {
        super(model, weight);
        this.setEngine(engine);
        this.setCargoWeight(cargoWeight);
    }

    public IEngine getEngine() {
        return engine;
    }

    private void setEngine(IEngine engine) {
        this.engine = engine;
    }

    private int getCargoWeight() {
        return cargoWeight;
    }

    private void setCargoWeight(int cargoWeight) {
        Validator.ValidatePropertyValue(cargoWeight, "Cargo Weight");
        this.cargoWeight = cargoWeight;
    }

    @Override
    public double CalculateRaceSpeed(IRace race) {
        return engine.getOutput() - (this.getWeight() + this.getCargoWeight()) + (race.getOceanCurrentSpeed() / 2.0);
    }

    @Override
    public boolean hasEngine() {
        return true;
    }
}
