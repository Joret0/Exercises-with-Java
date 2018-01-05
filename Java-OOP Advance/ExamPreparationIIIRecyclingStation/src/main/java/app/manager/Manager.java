package app.manager;

import app.waste_disposal.contracts.Waste;

public interface Manager {
    String processGarbageCommand(Waste garbage);
    String statusCommand();
    String changeManagementRequirement(double minEnergy, double minCapital, String type);
}
