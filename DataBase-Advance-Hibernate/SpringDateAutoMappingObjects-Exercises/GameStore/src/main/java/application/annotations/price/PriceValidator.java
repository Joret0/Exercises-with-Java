package application.annotations.price;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.math.BigDecimal;

public class PriceValidator implements ConstraintValidator<Price, BigDecimal>{

    int digits;

    @Override
    public void initialize(Price price) {
        this.digits = price.digitsAfterDecPlate();
    }

    private int getDigitsAfterDecPlate(String price) {
        String[] split = price.split("\\.");
        return split[1].length();
    }

    @Override
    public boolean isValid(BigDecimal bigDecimal, ConstraintValidatorContext constraintValidatorContext) {
        if (getDigitsAfterDecPlate(bigDecimal.toString()) != this.digits && getDigitsAfterDecPlate(bigDecimal.toString()) != 1) {
            return false;
        }
        return true;
    }
}
