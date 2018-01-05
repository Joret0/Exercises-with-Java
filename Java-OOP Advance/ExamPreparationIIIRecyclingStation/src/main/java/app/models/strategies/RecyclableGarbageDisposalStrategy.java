package app.models.strategies;

import app.models.data.ProcessingDataImpl;
import app.waste_disposal.contracts.GarbageDisposalStrategy;
import app.waste_disposal.contracts.ProcessingData;
import app.waste_disposal.contracts.Waste;

public class RecyclableGarbageDisposalStrategy implements GarbageDisposalStrategy{
    private static final int CAPITAL_EARNED_MULTIPLIER = 400;
    private static final double ENERGY_USED_PERCENTAGE = 50.0 / 100.0;

    @Override
    public ProcessingData processGarbage(Waste garbage) {
        double volume = garbage.getVolumePerKg() * garbage.getWeight();
        double energyBalance = -1 * volume * 0.5;
        double capitalBalance = garbage.getWeight() * 400;
        return new ProcessingDataImpl(energyBalance, capitalBalance);
    }
}
