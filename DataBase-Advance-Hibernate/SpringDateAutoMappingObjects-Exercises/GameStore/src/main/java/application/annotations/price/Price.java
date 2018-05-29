package application.annotations.price;

import org.springframework.stereotype.Component;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.constraints.NotNull;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@NotNull
@Component
@Constraint(validatedBy = PriceValidator.class)
@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Price {

    String message() default "Invalid price format.";
    int digitsAfterDecPlate() default 2;
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
