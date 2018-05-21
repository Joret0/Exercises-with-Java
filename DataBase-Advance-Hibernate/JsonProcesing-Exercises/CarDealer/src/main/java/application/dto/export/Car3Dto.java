package application.dto.export;

import com.google.gson.annotations.Expose;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

public class Car3Dto implements Serializable{

    @Expose
    private String make;
    @Expose
    private String model;
    @Expose
    private BigDecimal travelledDistance;
    @Expose
    private Set<Part2Dto> parts;

    public Car3Dto() {
        this.parts = new HashSet<>();
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public BigDecimal getTravelledDistance() {
        return travelledDistance;
    }

    public void setTravelledDistance(BigDecimal travelledDistance) {
        this.travelledDistance = travelledDistance;
    }

    public Set<Part2Dto> getParts() {
        return parts;
    }

    public void setParts(Set<Part2Dto> parts) {
        this.parts = parts;
    }
}
