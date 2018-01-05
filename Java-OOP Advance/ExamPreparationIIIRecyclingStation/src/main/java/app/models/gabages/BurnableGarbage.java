package app.models.gabages;

import app.waste_disposal.annotations.Burnable;

@Burnable
public class BurnableGarbage extends AbstractGarbage{
    public BurnableGarbage(String name, double volumePerKg, double weight) {
        super(name, volumePerKg, weight);
    }
}
