package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "teachers")
public class Teacher extends Person{

    @Column(name = "email")
    private String email;

    @Column(name = "salary_per_hour")
    private BigDecimal salaryPerHour;

    public Teacher() {
    }

    public Teacher(String email, BigDecimal salaryPerHour) {
        this.email = email;
        this.salaryPerHour = salaryPerHour;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public BigDecimal getSalaryPerHour() {
        return salaryPerHour;
    }

    public void setSalaryPerHour(BigDecimal salaryPerHour) {
        this.salaryPerHour = salaryPerHour;
    }
}
