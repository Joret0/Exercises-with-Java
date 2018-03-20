package entities.motor;

import entities.base.Motor;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.math.BigDecimal;

@Entity
public class Car extends Motor{
    @Column(name = "number_of_Doors")
    private int numberOfDoors;
    @Column(name = "information")
    private String information;

    public Car() {
    }

    public Car(int numberOfDoors, String information) {
        this.numberOfDoors = numberOfDoors;
        this.information = information;
    }

    public Car(String manufacturer, String model, BigDecimal price, int maxSpeed, int numberOfEngine, String engineType, int tankCapacity, int numberOfDoors, String information) {
        super(manufacturer, model, price, maxSpeed, numberOfEngine, engineType, tankCapacity);
        this.numberOfDoors = numberOfDoors;
        this.information = information;
    }

    public int getNumberOfDoors() {
        return numberOfDoors;
    }

    public void setNumberOfDoors(int numberOfDoors) {
        this.numberOfDoors = numberOfDoors;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }
}
