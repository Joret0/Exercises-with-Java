package app.models.gabages;

import app.waste_disposal.annotations.Recyclable;

@Recyclable
public class RecyclableGarbage extends AbstractGarbage{
    public RecyclableGarbage(String name, double volumePerKg, double weight) {
        super(name, volumePerKg, weight);
    }
}
