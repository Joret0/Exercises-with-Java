package app.manager;

import app.factories.RequirementFactory;
import app.waste_disposal.contracts.GarbageProcessor;
import app.waste_disposal.contracts.ProcessingData;
import app.waste_disposal.contracts.Waste;
import app.waste_disposal.managementSystems.Requirement;

public class WasteManager implements Manager{
    private static final String F_KG_OF_S_SUCCESSFULLY_PROCESSED = "%.2f kg of %s successfully processed!";
    private static final String ENERGY_2F_CAPITAL_2F = "Energy: %.2f Capital: %.2f";
    private static final String PROCESSING_DENIED = "Processing Denied!";
    private static final String MANAGEMENT_REQUIREMENT_CHANGED = "Management requirement changed!";
    private static final String GARBAGE_SUFFIX = "Garbage";
    private static final String EMPTY_STRING = "";

    private double energy;
    private double capital;
    private GarbageProcessor processor;
    private Requirement requirement;

    public WasteManager(double energy, double capital, GarbageProcessor processor, Requirement requirement) {
        this.energy = energy;
        this.capital = capital;
        this.processor = processor;
        this.requirement = requirement;
    }

    public WasteManager(GarbageProcessor processor) {
        this(0D, 0D, processor, null);
    }

    @Override
    public String processGarbageCommand(Waste garbage) {
        ProcessingData processedGarbage = this.processor.processWaste(garbage);

        if (this.requirement == null) {
            this.energy += processedGarbage.getEnergyBalance();
            this.capital += processedGarbage.getCapitalBalance();
            return String.format(F_KG_OF_S_SUCCESSFULLY_PROCESSED, garbage.getWeight(), garbage.getName());
        }
        if (garbage.getClass().getSimpleName().replace(GARBAGE_SUFFIX, EMPTY_STRING).equals(this.requirement.getType())) {
            if (this.energy >= this.requirement.getEnergyBalance() &&
                    this.capital >= this.requirement.getCapitalBalance()) {
                this.energy += processedGarbage.getEnergyBalance();
                this.capital += processedGarbage.getCapitalBalance();
                return String.format(F_KG_OF_S_SUCCESSFULLY_PROCESSED, garbage.getWeight(), garbage.getName());
            }
            return PROCESSING_DENIED;
        } else {
            this.energy += processedGarbage.getEnergyBalance();
            this.capital += processedGarbage.getCapitalBalance();
            return String.format(F_KG_OF_S_SUCCESSFULLY_PROCESSED, garbage.getWeight(), garbage.getName());
        }
    }

    @Override
    public String statusCommand() {
        return String.format(ENERGY_2F_CAPITAL_2F, this.energy, this.capital);
    }

    @Override
    public String changeManagementRequirement(double minEnergy, double minCapital, String type) {
        this.requirement = RequirementFactory.create(type, minEnergy, minCapital);
        return MANAGEMENT_REQUIREMENT_CHANGED;
    }
}
