package com.out.io2.timetable.controllers;

import com.out.io2.timetable.api.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Handles exception for web layer of application.
 * Aspect Advice
 */

@ControllerAdvice
@CrossOrigin
public class ErrorHandler {

    /**
     * Catches exception and maps it on readable Error Messages
     * @param ex Validation exception
     * @return readable error messages
     */

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public List<ErrorMessage> handleValidationError(MethodArgumentNotValidException ex) {
        BindingResult result = ex.getBindingResult();
        List<FieldError> fieldErrors = result.getFieldErrors();
        return fieldErrors.stream()
                .map(error -> new ErrorMessage(error.getDefaultMessage(), error.getField()))
                .collect(Collectors.toList());
    }
}
