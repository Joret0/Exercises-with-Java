package application.dto;

import com.google.gson.annotations.Expose;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class SoldProducts implements Serializable{

    @Expose
    private int count;
    @Expose
    private Set<ProductDto> products;

    public SoldProducts() {
        this.products = new HashSet<>();
    }

    public Set<ProductDto> getProducts() {
        return products;
    }

    public void setProducts(Set<ProductDto> products) {
        this.products = products;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
