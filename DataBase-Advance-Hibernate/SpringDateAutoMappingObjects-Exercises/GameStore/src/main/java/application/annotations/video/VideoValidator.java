package application.annotations.video;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class VideoValidator implements ConstraintValidator<Video, String> {
    @Override
    public void initialize(Video video) {

    }

    @Override
    public boolean isValid(String video, ConstraintValidatorContext constraintValidatorContext) {
        if (video.length() != 11) {
            return false;
        }
        return true;
    }
}
