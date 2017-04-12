package com.out.io2.timetable.commons;


import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class DefinedValuesValidator implements ConstraintValidator<DefinedValues, String>{
    private List<String> acceptableValues = Collections.emptyList();

    @Override
    public void initialize(DefinedValues definedValues) {
        acceptableValues = Arrays.asList(definedValues.valueSet());
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        return acceptableValues.contains(value);
    }
}
