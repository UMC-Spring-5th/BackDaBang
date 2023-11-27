package umc.BackDaBang.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.BackDaBang.apiPayload.code.status.ErrorStatus;
import umc.BackDaBang.validation.annotation.CheckPage;

@Component
@RequiredArgsConstructor
public class CheckPageValidator implements ConstraintValidator<CheckPage, Integer> {

    @Override
    public void initialize(CheckPage constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        
        //페이지 번호는 0 이상이여야함
        boolean isValid;
        if(value != null && value >= 0) isValid = true ;
        else {
            isValid = false;
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.PAGE_INVALID.toString()).addConstraintViolation();
        }

        return isValid;
    }
}
