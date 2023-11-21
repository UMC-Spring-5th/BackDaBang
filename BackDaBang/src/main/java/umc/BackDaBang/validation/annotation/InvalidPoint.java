package umc.BackDaBang.validation.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import umc.BackDaBang.validation.validator.PointValidator;
import umc.BackDaBang.validation.validator.TypesExistValidator;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = PointValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface InvalidPoint {

    String message() default "포인트는 100단위여야 합니다.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
