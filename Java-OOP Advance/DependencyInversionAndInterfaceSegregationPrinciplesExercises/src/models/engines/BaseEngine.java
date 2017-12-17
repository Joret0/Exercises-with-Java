package models.engines;

import interfaces.IEngine;
import utilities.Constants;
import utilities.Validator;

public abstract class BaseEngine implements IEngine{
    private String model;
    private int horsepower;
    private int displacement;
    private int cachedOutput;

    BaseEngine(String model, int horsepower, int displacement) {
        this.setModel(model);
        this.setHorsepower(horsepower);
        this.setDisplacement(displacement);
    }

    @Override
    public int getHorsepower() {
        return horsepower;
    }


    @Override
    public int getDisplacement() {
        return displacement;
    }

    @Override
    public String getModel() {
        return this.model;
    }

    @Override
    public int getCachedOutput() {
        return cachedOutput;
    }

    public void setModel(String model) {
        Validator.ValidateModelLength(model, Constants.MinBoatEngineModelLength);
        this.model = model;
    }

    private void setHorsepower(int horsepower) {
        Validator.ValidatePropertyValue(horsepower, "Horsepower");
        this.horsepower = horsepower;
    }

    private void setDisplacement(int displacement) {
        Validator.ValidatePropertyValue(displacement, "Displacement");
        this.displacement = displacement;
    }


    void setCachedOutput(int cachedOutput) {
        this.cachedOutput = cachedOutput;
    }
}
