package app.factories;

import app.waste_disposal.managementSystems.ManagementRequirement;
import app.waste_disposal.managementSystems.Requirement;

public class RequirementFactory {
    public static Requirement create(String type, double energy, double capital) {
        return new ManagementRequirement(type, energy, capital);
    }
}
