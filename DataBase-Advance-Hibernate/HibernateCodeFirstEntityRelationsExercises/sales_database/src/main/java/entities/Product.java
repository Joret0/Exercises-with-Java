package entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Basic
    private String name;
    @Basic
    private BigDecimal price;
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private Set<Sale> productSales;

    public Product() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public Set<Sale> getProductSales() {
        return productSales;
    }

    public void setProductSales(Set<Sale> productSales) {
        this.productSales = productSales;
    }
}
