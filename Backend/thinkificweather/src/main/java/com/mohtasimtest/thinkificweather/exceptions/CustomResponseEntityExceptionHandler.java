package com.mohtasimtest.thinkificweather.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class CustomResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<Object> handleInvalidCityNameException(InvalidCityNameException invalidCityNameException,
                                                                 WebRequest request) {
        InvalidCityNameExceptionResponse invalidCityNameExceptionResponse = new InvalidCityNameExceptionResponse(invalidCityNameException.getMessage());
        return new ResponseEntity(invalidCityNameExceptionResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public final ResponseEntity<Object> handleUsernameAlreadyExistsException(UsernameAlreadyExistsException usernameAlreadyExistsException,
                                                                             WebRequest request) {
        UsernameAlreadyExistsResponse usernameAlreadyExistsResponse = new UsernameAlreadyExistsResponse((usernameAlreadyExistsException.getMessage()));
        return new ResponseEntity(usernameAlreadyExistsResponse, HttpStatus.BAD_REQUEST);
    }
}
