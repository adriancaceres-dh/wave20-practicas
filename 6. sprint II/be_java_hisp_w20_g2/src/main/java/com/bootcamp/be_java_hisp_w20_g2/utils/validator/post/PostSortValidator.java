package com.bootcamp.be_java_hisp_w20_g2.utils.validator.post;

import com.bootcamp.be_java_hisp_w20_g2.utils.sort.PostStreamSorter;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Optional;

public class PostSortValidator implements ConstraintValidator<PostSorterConstraint, Optional<String>> {
    @Override
    public void initialize(PostSorterConstraint constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Optional<String> order, ConstraintValidatorContext constraintValidatorContext) {
        return order.map(PostStreamSorter::isValid).orElse(true);
    }
}
