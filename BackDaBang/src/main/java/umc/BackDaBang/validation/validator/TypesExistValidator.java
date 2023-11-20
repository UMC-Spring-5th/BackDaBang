package umc.BackDaBang.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.BackDaBang.apiPayload.code.status.ErrorStatus;
import umc.BackDaBang.repository.FoodTypeRepository;
import umc.BackDaBang.validation.annotation.ExistTypes;

import java.util.List;

@Component
@RequiredArgsConstructor
public class TypesExistValidator implements ConstraintValidator<ExistTypes, List<Long>> {

    private final FoodTypeRepository foodTypeRepository;
    @Override
    public void initialize(ExistTypes constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(List<Long> values, ConstraintValidatorContext context) {
        boolean isValid = values.stream()
                .allMatch(foodTypeRepository::existsById);

        if (!isValid) {
            context.disableDefaultConstraintViolation();;
            context.buildConstraintViolationWithTemplate(ErrorStatus.FOOD_TYPE_NOT_FOUND.toString()).addConstraintViolation();
        }

        return isValid;
    }
}