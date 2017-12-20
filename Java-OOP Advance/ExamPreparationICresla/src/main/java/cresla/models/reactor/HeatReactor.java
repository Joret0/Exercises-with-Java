package cresla.models.reactor;

import cresla.interfaces.Container;

public class HeatReactor extends AbstractReactor{
    private int heatReductionIndex;

    public HeatReactor(int id, Container container, int index) {
        super(id, container);
        this.heatReductionIndex = index;
    }

    @Override
    public long getTotalEnergyOutput() {
        long result = super.getContainer().getTotalEnergyOutput();
        if (result > this.getTotalHeatAbsorbing()) {
            result = 0;
        }
        return result;
    }

    @Override
    public long getTotalHeatAbsorbing() {
        return super.getContainer().getTotalHeatAbsorbing() + this.heatReductionIndex;
    }

    @Override
    public String toString() {
        return  "HeatReactor - " + super.getId() + System.lineSeparator() +
                "Energy Output: " + this.getTotalEnergyOutput() + System.lineSeparator() +
                "Heat Absorbing: " + this.getTotalHeatAbsorbing() + System.lineSeparator() +
                "Modules: " + this.getModuleCount();
    }
}
