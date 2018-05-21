package application.dto;

import application.entities.Product;
import com.google.gson.annotations.Expose;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class UserOutDto implements Serializable{

    @Expose
    private String firstName;
    @Expose
    private String lastName;
    @Expose
    private Set<ProductOutDto2> soldProducts;

    public UserOutDto() {
        this.soldProducts = new HashSet<>();
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Set<ProductOutDto2> getSoldProducts() {
        return soldProducts;
    }

    public void setSoldProducts(Set<ProductOutDto2> soldProducts) {
        this.soldProducts = soldProducts;
    }
}
