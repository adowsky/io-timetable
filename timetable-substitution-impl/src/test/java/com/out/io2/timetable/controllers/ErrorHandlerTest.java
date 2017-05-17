package com.out.io2.timetable.controllers;

import com.out.io2.timetable.api.ErrorMessage;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ErrorHandlerTest {
    private ErrorHandler errorHandler = new ErrorHandler();

    @Test
    public void shouldReturnListWithErrors() {
        //given
        MethodArgumentNotValidException givenException = mock(MethodArgumentNotValidException.class);
        BindingResult bindingResult = mock(BindingResult.class);
        List<FieldError> givenErrors = Collections.singletonList(new FieldError("object", "field", "message"));
        when(givenException.getBindingResult()).thenReturn(bindingResult);
        when(bindingResult.getFieldErrors()).thenReturn(givenErrors);

        //when
        List<ErrorMessage> actual = errorHandler.handleValidationError(givenException);

        //then
        assertThat(actual).hasSize(1);
        assertThat(actual.get(0)).isEqualToComparingFieldByField(new ErrorMessage("message", "field"));
    }
}