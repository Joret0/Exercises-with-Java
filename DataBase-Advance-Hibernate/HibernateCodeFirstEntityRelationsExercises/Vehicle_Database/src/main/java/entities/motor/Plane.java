package entities.motor;

import entities.base.Motor;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.math.BigDecimal;

@Entity
public class Plane extends Motor{
    @Column(name = "airline_owner")
    private String airlineOwner;
    @Column(name = "color")
    private String color;
    @Column(name = "passenger_capacity")
    private int passengerCapacity;

    public Plane() {
    }

    public Plane(String airlineOwner, String color, int passengerCapacity) {
        this.airlineOwner = airlineOwner;
        this.color = color;
        this.passengerCapacity = passengerCapacity;
    }

    public Plane(String manufacturer, String model, BigDecimal price, int maxSpeed, int numberOfEngine, String engineType, int tankCapacity, String airlineOwner, String color, int passengerCapacity) {
        super(manufacturer, model, price, maxSpeed, numberOfEngine, engineType, tankCapacity);
        this.airlineOwner = airlineOwner;
        this.color = color;
        this.passengerCapacity = passengerCapacity;
    }

    public String getAirlineOwner() {
        return airlineOwner;
    }

    public void setAirlineOwner(String airlineOwner) {
        this.airlineOwner = airlineOwner;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    public void setPassengerCapacity(int passengerCapacity) {
        this.passengerCapacity = passengerCapacity;
    }
}
