package application.dto;

import com.google.gson.annotations.Expose;

import java.io.Serializable;
import java.math.BigDecimal;

public class ProductOutDto2 implements Serializable{

    @Expose
    private String name;
    @Expose
    private BigDecimal price;
    @Expose
    private String firstNameBuyer;
    @Expose
    private String lastNameBuyer;

    public ProductOutDto2() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getFirstNameBuyer() {
        return firstNameBuyer;
    }

    public void setFirstNameBuyer(String firstNameBuyer) {
        this.firstNameBuyer = firstNameBuyer;
    }

    public String getLastNameBuyer() {
        return lastNameBuyer;
    }

    public void setLastNameBuyer(String lastNameBuyer) {
        this.lastNameBuyer = lastNameBuyer;
    }
}
