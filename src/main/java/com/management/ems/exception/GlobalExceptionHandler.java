package com.management.ems.exception;

import com.management.ems.utility.ResponseError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler extends RuntimeException {

    @ExceptionHandler(UserException.class)
    public ResponseEntity<ResponseError> handleUserException(UserException userException){

        ResponseError error= ResponseError.builder().message(userException.getMessage()).code(HttpStatus.NOT_FOUND.value()).build();
        return new ResponseEntity<>(error ,HttpStatus.NOT_FOUND);
    }
}
