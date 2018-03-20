package entities.motor.train;

import javax.persistence.*;

@Entity
public class Carriage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "carriage_id")
    private long id;
    @Column(name = "carriage_type")
    private CarriageType carriageType;
    @Column(name = "carriage_type_count")
    private int carriageTypeCount;
    @ManyToOne()
    @JoinColumn(name = "vehicle_id", referencedColumnName = "vehicle_id")
    private Train train;

    public Carriage() {
    }

    public Carriage(CarriageType carriageType, int carriageTypeCount, Train train) {
        this.carriageType = carriageType;
        this.carriageTypeCount = carriageTypeCount;
        this.train = train;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public CarriageType getCarriageType() {
        return carriageType;
    }

    public void setCarriageType(CarriageType carriageType) {
        this.carriageType = carriageType;
    }

    public int getCarriageTypeCount() {
        return carriageTypeCount;
    }

    public void setCarriageTypeCount(int carriageTypeCount) {
        this.carriageTypeCount = carriageTypeCount;
    }

    public Train getTrain() {
        return train;
    }

    public void setTrain(Train train) {
        this.train = train;
    }
}
