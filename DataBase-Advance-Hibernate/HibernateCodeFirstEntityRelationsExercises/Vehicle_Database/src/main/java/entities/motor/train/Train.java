package entities.motor.train;

import entities.base.Motor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

@Entity
public class Train extends Motor{

    @OneToOne
    @JoinColumn(name = "locomotive_id", referencedColumnName = "locomotive_id")
    private Locomotive locomotive;
    @Column(name = "number_of_carriage")
    private int numberOfCarriage;
    @OneToMany(mappedBy = "train")
    private Set<Carriage> carriages;

    public Train() {
    }

    public Train(String manufacturer, String model, BigDecimal price, int maxSpeed, int numberOfEngine, String engineType, int tankCapacity, Locomotive locomotive, int numberOfCarriage, Set<Carriage> carriages) {
        super(manufacturer, model, price, maxSpeed, numberOfEngine, engineType, tankCapacity);
        this.locomotive = locomotive;
        this.numberOfCarriage = numberOfCarriage;
        this.carriages = carriages;
    }

    public Locomotive getLocomotive() {
        return locomotive;
    }

    public void setLocomotive(Locomotive locomotive) {
        this.locomotive = locomotive;
    }

    public int getNumberOfCarriage() {
        return numberOfCarriage;
    }

    public void setNumberOfCarriage(int numberOfCarriage) {
        this.numberOfCarriage = numberOfCarriage;
    }

    public Set<Carriage> getCarriages() {
        return carriages;
    }

    public void setCarriages(Set<Carriage> carriages) {
        this.carriages = carriages;
    }
}
