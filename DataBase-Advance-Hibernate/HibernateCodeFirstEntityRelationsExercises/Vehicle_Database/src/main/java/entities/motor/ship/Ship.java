package entities.motor.ship;

import entities.base.Motor;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.math.BigDecimal;

@Entity
public abstract class Ship extends Motor{
    @Column(name = "nationality")
    private String nationality;
    @Column(name = "captain_name")
    private String captainName;
    @Column(name = "crew_size")
    private int crewSize;

    public Ship() {
    }

    public Ship(String manufacturer, String model, BigDecimal price, int maxSpeed, int numberOfEngine, String engineType, int tankCapacity, String nationality, String captainName, int crewSize) {
        super(manufacturer, model, price, maxSpeed, numberOfEngine, engineType, tankCapacity);
        this.nationality = nationality;
        this.captainName = captainName;
        this.crewSize = crewSize;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getCaptainName() {
        return captainName;
    }

    public void setCaptainName(String captainName) {
        this.captainName = captainName;
    }

    public int getCrewSize() {
        return crewSize;
    }

    public void setCrewSize(int crewSize) {
        this.crewSize = crewSize;
    }
}
