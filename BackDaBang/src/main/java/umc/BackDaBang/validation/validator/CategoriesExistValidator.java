package umc.BackDaBang.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.BackDaBang.apiPayload.code.status.ErrorStatus;
import umc.BackDaBang.repository.FoodTypeRepository;
import umc.BackDaBang.service.FoodTypeService.FoodTypeService;
import umc.BackDaBang.validation.annotation.ExistCategories;

import java.util.List;

@Component
@RequiredArgsConstructor
public class CategoriesExistValidator implements ConstraintValidator<ExistCategories, List<Long>> {
    private final FoodTypeService foodTypeService;

    @Override
    public void initialize(ExistCategories constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(List<Long> values, ConstraintValidatorContext context) {
        boolean isValid = values.stream()
                .allMatch(value -> foodTypeService.existsById(value));

        if (!isValid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.FOOD_TYPE_NOT_FOUND.toString()).addConstraintViolation();
        }

        return isValid;
    }
}
