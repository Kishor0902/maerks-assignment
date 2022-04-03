package com.maersk.containerbookingservice.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class OneOfValidator implements ConstraintValidator<OneOf, Integer> {
    @Override
    public void initialize(OneOf constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        return true;
    }
}
