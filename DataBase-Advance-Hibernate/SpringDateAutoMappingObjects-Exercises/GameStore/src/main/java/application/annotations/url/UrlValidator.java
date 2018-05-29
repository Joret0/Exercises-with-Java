package application.annotations.url;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UrlValidator implements ConstraintValidator<Url, String> {
    @Override
    public void initialize(Url url) {

    }

    @Override
    public boolean isValid(String url, ConstraintValidatorContext constraintValidatorContext) {
        if (url.startsWith("http://") || url.startsWith("https://") || url.equals("")) {
            return true;
        }
        return false;
    }
}
