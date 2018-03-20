package entities;

import javax.persistence.*;
import java.util.Set;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class StoreLocation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Basic
    private String locationName;
    @OneToMany(mappedBy = "storeLocation", cascade = CascadeType.ALL)
    private Set<Sale> locationSales;

    public StoreLocation() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public Set<Sale> getLocationSales() {
        return locationSales;
    }

    public void setLocationSales(Set<Sale> locationSales) {
        this.locationSales = locationSales;
    }
}
