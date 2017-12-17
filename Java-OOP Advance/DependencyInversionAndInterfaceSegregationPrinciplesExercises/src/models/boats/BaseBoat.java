package models.boats;

import interfaces.IBoat;
import utilities.Constants;
import utilities.Validator;

public abstract class BaseBoat implements IBoat{
    private String model;
    private int weight;

    BaseBoat(String model, int weight) {
        this.setModel(model);
        this.setWeight(weight);
    }

    @Override
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        Validator.ValidateModelLength(model, Constants.MinBoatModelLength);
        this.model = model;
    }

    @Override
    public int getWeight() {
        return weight;
    }

    private void setWeight(int weight) {
        Validator.ValidatePropertyValue(weight, "Weight");
        this.weight = weight;
    }
}
