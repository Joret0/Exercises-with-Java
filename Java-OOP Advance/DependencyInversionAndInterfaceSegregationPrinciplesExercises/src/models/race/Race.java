package models.race;

import exeptions.DuplicateModelException;
import interfaces.IBoat;
import interfaces.IRace;
import utilities.Constants;
import utilities.Validator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public class Race implements IRace{
    private int distance;
    private int windSpeed;
    private int oceanCurrentSpeed;
    private HashMap<String, IBoat> registeredBoats;

    private boolean allowsMotorBoats;
    private boolean isSet;

    public Race() {
    }

    public Race(int distance, int windSpeed, int oceanCurrentSpeed, boolean allowsMotorBoats) {
        this.setDistance(distance);
        this.setWindSpeed(windSpeed);
        this.setOceanCurrentSpeed(oceanCurrentSpeed);
        this.setAllowsMotorBoats(allowsMotorBoats);
        this.registeredBoats = new LinkedHashMap<>();
    }

    @Override
    public int getDistance() {
        return distance;
    }

    private void setDistance(int distance) {
        Validator.ValidatePropertyValue(distance, "Distance");
        this.distance = distance;
    }

    @Override
    public int getWindSpeed() {
        return windSpeed;
    }

    private void setWindSpeed(int windSpeed) {
        this.windSpeed = windSpeed;
    }

    public int getOceanCurrentSpeed() {
        return oceanCurrentSpeed;
    }

    private void setOceanCurrentSpeed(int oceanCurrentSpeed) {
        this.oceanCurrentSpeed = oceanCurrentSpeed;
    }

    public boolean getAllowsMotorboats() {
        return allowsMotorBoats;
    }

    private void setAllowsMotorBoats(boolean allowsMotorBoats) {
        this.allowsMotorBoats = allowsMotorBoats;
    }

    protected HashMap<String, IBoat> getRegisteredBoats() {
        return this.registeredBoats;
    }

    @Override
    public void AddParticipant(IBoat boat) throws DuplicateModelException {
        if (this.getRegisteredBoats().containsKey(boat.getModel())) {
            throw new DuplicateModelException(Constants.DuplicateModelMessage);
        }
        this.registeredBoats.put(boat.getModel(), boat);
    }

    @Override
    public List<IBoat> GetParticipants() {
        return new ArrayList<>(this.registeredBoats.values());
    }
}
