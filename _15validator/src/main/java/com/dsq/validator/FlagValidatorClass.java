package com.dsq.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Created by aa on 2019/7/14.
 */
public class FlagValidatorClass implements ConstraintValidator<FlagValidator, Object> {

    private String values;

    @Override
    public void initialize(FlagValidator constraintAnnotation) {
        this.values = constraintAnnotation.values();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext constraintValidatorContext) {
        String[] valueArray = values.split(",");
        boolean flag = false;
        for (int i = 0; i < valueArray.length; i++) {
            if(valueArray[i].equals(value)) {
                flag = true;
                break;
            }
        }

        return flag;
    }
}
