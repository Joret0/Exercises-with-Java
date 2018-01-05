package app.models.gabages;

import app.waste_disposal.contracts.Waste;

public abstract class AbstractGarbage implements Waste{
    private String name;
    private double weight;
    private double volumePerKg;

    protected AbstractGarbage(String name, double volumePerKg, double weight) {
        this.name = name;
        this.weight = weight;
        this.volumePerKg = volumePerKg;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public double getVolumePerKg() {
        return this.volumePerKg;
    }

    @Override
    public double getWeight() {
        return this.weight;
    }
}
