package interfaces;

import java.math.BigDecimal;

public interface Vehicle {
    String getManufacturer();
    String getModel();
    BigDecimal getPrice();
    int getMaxSpeed();
}
