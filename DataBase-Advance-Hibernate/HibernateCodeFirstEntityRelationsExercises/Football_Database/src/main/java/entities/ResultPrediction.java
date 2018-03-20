package entities;

import javax.persistence.*;

@Entity
@Table(name = "result_prediction")
@Inheritance(strategy = InheritanceType.JOINED)
public class ResultPrediction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "prediction")
    private String prediction;

    public ResultPrediction() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPrediction() {
        return prediction;
    }

    public void setPrediction(String prediction) {
        this.prediction = prediction;
    }
}
