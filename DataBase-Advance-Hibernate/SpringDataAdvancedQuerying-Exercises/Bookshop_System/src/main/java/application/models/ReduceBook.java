package application.models;

import application.enums.AgeRestriction;
import application.enums.EditionType;

import java.math.BigDecimal;

public interface ReduceBook {
    String getTitle();
    void setTitle(String title);

    String getEditionType();
    void setEditionType(EditionType editionType);

    AgeRestriction getAgeRestriction();
    void setAgeRestriction(AgeRestriction ageRestriction);

    BigDecimal getPrice();
    void setPrice(BigDecimal price);
}
