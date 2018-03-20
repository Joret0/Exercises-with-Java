package models.products;

import enums.Size;
import interfaces.Shampoo;
import models.ingredients.BasicIngredient;
import models.labels.BasicLabel;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "shampoos")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "shampoo_type", discriminatorType = DiscriminatorType.STRING)
public class BasicShampoo implements Shampoo{
    @Id
    private long id;
    @Basic
    private BigDecimal price;
    @Basic
    private String brand;
    @Enumerated
    private Size size;
    @OneToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "label_id", referencedColumnName = "id")
    private BasicLabel basicLabel;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "shampoos_ingredients",
    joinColumns = @JoinColumn(name = "shampoo_id",
    referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name = "ingredient_id",
    referencedColumnName = "id"))
    private Set<BasicIngredient> ingredients;

    protected BasicShampoo() {
        this.setIngredients(new HashSet<>());
    }

    public BasicShampoo(String brand, BigDecimal price, Size size, BasicLabel classicLabel) {
        this.brand = brand;
        this.price = price;
        this.size = size;
        this.basicLabel = classicLabel;
    }

    @Override
    public long getId() {
        return this.id;
    }

    @Override
    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String getBrand() {
        return this.brand;
    }

    @Override
    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public BigDecimal getPrice() {
        return this.price;
    }

    @Override
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public Size getSize() {
        return this.size;
    }

    @Override
    public void setSize(Size size) {
        this.size = size;
    }

    @Override
    public BasicLabel getLabel() {
        return this.basicLabel;
    }

    @Override
    public void setLabel(BasicLabel label) {
        this.basicLabel = label;
    }

    @Override
    public Set<BasicIngredient> getIngredients() {
        return this.ingredients;
    }

    @Override
    public void setIngredients(Set<BasicIngredient> ingredients) {
        this.ingredients = ingredients;
    }
}
