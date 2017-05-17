package com.out.io2.timetable.commons;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import javax.validation.ConstraintValidatorContext;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class DefinedValuesValidatorTest {
    private static final String[] DEFINED_VALUES = new String[] { "my Value" };

    @Mock
    private DefinedValues definedValues;
    @Mock
    private ConstraintValidatorContext constraintValidatorContext;
    private DefinedValuesValidator validator;

    @Before
    public void setUp() {
        validator = new DefinedValuesValidator();
        when(definedValues.valueSet()).thenReturn(DEFINED_VALUES);
        validator.initialize(definedValues);
    }

    @Test
    public void shouldReturnFalseForNotIncludedValue() {
        //when
        boolean actual = validator.isValid("other value", constraintValidatorContext);

        //then
        assertThat(actual).isFalse();
    }

    @Test
    public void shouldReturnTrueForIncludedValue() {
        //when
        boolean actual = validator.isValid("my Value", constraintValidatorContext);

        //then
        assertThat(actual).isTrue();
    }

    @Test
    public void shouldReturnFalseForNullValue() {
        //when
        boolean actual = validator.isValid(null, constraintValidatorContext);

        //then
        assertThat(actual).isFalse();
    }

    @Test
    public void shouldReturnTrueWithoutContext() {
        //when
        boolean actual = validator.isValid("my Value", null);

        //then
        assertThat(actual).isTrue();
    }
}