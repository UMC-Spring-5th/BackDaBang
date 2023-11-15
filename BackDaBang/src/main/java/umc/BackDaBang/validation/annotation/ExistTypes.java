package umc.BackDaBang.validation.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import umc.BackDaBang.validation.validator.TypesExistValidator;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = TypesExistValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface ExistTypes {

    String message() default "해당하는 타입이 존재하지 않습니다.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
