package com.project.ecomapplication.exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@RestController
@ControllerAdvice
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {InvalidTokenException.class})
    public ResponseEntity<Object> handleTokenNotFoundException(InvalidTokenException e) {
        return new ResponseEntity<>(e, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = {EmailAlreadyConfirmedException.class})
    public ResponseEntity<Object> handleEmailAlreadyConfirmedException(EmailAlreadyConfirmedException e) {
        return new ResponseEntity<>(e, HttpStatus.ALREADY_REPORTED);
    }

    @ExceptionHandler(value = {TokenExpiredException.class})
    public ResponseEntity<Object> handleTokenExpiredException(TokenExpiredException e) {
        return new ResponseEntity<>(e, HttpStatus.BAD_REQUEST);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        Map<String,String> errorMap = new HashMap<>();
        ex.getBindingResult()
                .getFieldErrors() // returns a list of errors
                .forEach(fieldError -> {
                    // populating map with, field with error as key, and relevant message as value
                    errorMap.put(fieldError.getField(), fieldError.getDefaultMessage());

                });

       // return this.handleExceptionInternal(ex, errorMap, headers, status, request);
        return new ResponseEntity<>(errorMap, headers, status);


    }
}
