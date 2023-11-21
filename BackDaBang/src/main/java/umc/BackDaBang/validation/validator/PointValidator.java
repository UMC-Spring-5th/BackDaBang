package umc.BackDaBang.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.BackDaBang.apiPayload.code.status.ErrorStatus;
import umc.BackDaBang.validation.annotation.InvalidPoint;

@Component
@RequiredArgsConstructor
public class PointValidator implements ConstraintValidator<InvalidPoint, Long> {
    @Override
    public void initialize(InvalidPoint constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {
        boolean isValid = (value % 100 == 0);

        if(!isValid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.INVALID_MISSION_POINT.getMessage()).addConstraintViolation();
        }

        return isValid;
    }
}
