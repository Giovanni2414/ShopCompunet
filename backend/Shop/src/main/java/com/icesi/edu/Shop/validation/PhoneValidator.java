package com.icesi.edu.Shop.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PhoneValidator implements ConstraintValidator<CustomAnnotations.PhoneValidation, String> {

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if(s == null) {
            return true;
        }
        if(!s.equals("")) {
            return s.length() == 10;
        } else {
            return true;
        }

    }

}
