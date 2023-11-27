package umc.BackDaBang.validation.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import umc.BackDaBang.validation.validator.CheckPageValidator;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = CheckPageValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface CheckPage {

    String message() default "페이지는 0보다 크거나 같아야합니다.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
