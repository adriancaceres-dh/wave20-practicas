package com.bootcamp.be_java_hisp_w20_g2_podio.utils.validator.userResponse;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = UserResponseSortValidator.class)
public @interface UserResponseSorterConstraint {
    String message() default "Invalid User sort criteria";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
