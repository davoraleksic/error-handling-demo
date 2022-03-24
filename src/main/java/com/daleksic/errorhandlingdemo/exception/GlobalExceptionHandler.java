package com.daleksic.errorhandlingdemo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.persistence.EntityNotFoundException;
import java.util.Date;

@ControllerAdvice
public class GlobalExceptionHandler {

//    @ExceptionHandler(value = EntityNotFoundException.class)
//    public ResponseEntity<ErrorDetails> handleEntityNotFoundException(EntityNotFoundException entityNotFoundException){
//        ErrorDetails errorDetails = new ErrorDetails();
//        errorDetails.setTimestamp(new Date());
//        errorDetails.setMessage(entityNotFoundException.getMessage());
//        errorDetails.setHttpStatus(HttpStatus.NOT_FOUND.getReasonPhrase());
//
//        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
//    }
//
//    @ExceptionHandler(value = GenericValidationException.class)
//    public ResponseEntity<ErrorDetails> handleGenericValidationException(GenericValidationException genericValidationException){
//        ErrorDetails errorDetails = new ErrorDetails();
//        errorDetails.setTimestamp(new Date());
//        errorDetails.setMessage(genericValidationException.getMessage());
//        errorDetails.setHttpStatus(HttpStatus.BAD_REQUEST.getReasonPhrase());
//
//        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
//    }

//    @ExceptionHandler(value = NoSuchElementException.class)
//    public ResponseEntity<?> handleNoSuchElementException(){
//        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//    }

    @ExceptionHandler(value = EntityNotFoundException.class)
    public ResponseEntity<ErrorDetails> handleEntityNotFoundException(EntityNotFoundException entityNotFoundException){
        ErrorDetails errorDetails = prepareErrorDetails(entityNotFoundException);
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = GenericValidationException.class)
    public ResponseEntity<ErrorDetails> handleGenericValidationException(GenericValidationException genericValidationException){
        ErrorDetails errorDetails = prepareErrorDetails(genericValidationException);
        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
    }

    private ErrorDetails prepareErrorDetails(Exception exception){
        ErrorDetails errorDetails = new ErrorDetails();
        errorDetails.setTimestamp(new Date());
        errorDetails.setMessage(exception.getMessage());
        return errorDetails;
    }
}
