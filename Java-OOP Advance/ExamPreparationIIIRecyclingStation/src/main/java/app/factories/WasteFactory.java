package app.factories;

import app.models.gabages.BurnableGarbage;
import app.models.gabages.RecyclableGarbage;
import app.models.gabages.StorableGarbage;
import app.waste_disposal.contracts.Waste;

public class WasteFactory {
    public static Waste create(String name, double weight, double volume, String type) {
        switch (type) {
            case "Recyclable":
                return new RecyclableGarbage(name, volume, weight);
            case "Burnable":
                return new BurnableGarbage(name, volume, weight);
            case "Storable":
                return new StorableGarbage(name, volume, weight);
            default:
                return null;
        }
    }
}
