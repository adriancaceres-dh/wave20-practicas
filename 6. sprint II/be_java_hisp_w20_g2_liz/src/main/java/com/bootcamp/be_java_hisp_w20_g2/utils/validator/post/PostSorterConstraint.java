package com.bootcamp.be_java_hisp_w20_g2.utils.validator.post;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = PostSortValidator.class)
public @interface PostSorterConstraint {
    String message() default "Invalid Post sort criteria";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
