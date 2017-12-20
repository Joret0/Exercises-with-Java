package cresla.models.modules;

import cresla.interfaces.EnergyModule;

public abstract class AbstractEnergyModule extends AbstractModule implements EnergyModule{
    private int energyOutPut;

    protected AbstractEnergyModule(int id, int output) {
        super(id);
        this.energyOutPut = output;
    }

    @Override
    public int getEnergyOutput() {
        return this.energyOutPut;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " Module - " + super.getId() + System.lineSeparator() +
                "Energy Output: " + this.energyOutPut;
    }
}
