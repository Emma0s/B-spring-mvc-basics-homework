package com.thoughtworks.capacity.gtb.mvc.exception;

import com.thoughtworks.capacity.gtb.mvc.exception.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.Objects;
import java.util.Set;

@ControllerAdvice
public class UserExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorMessage> handle(MethodArgumentNotValidException ex){
        String message = Objects.requireNonNull(ex.getBindingResult().getFieldError()).getDefaultMessage();
        ErrorMessage errorMessage = new ErrorMessage(HttpStatus.NOT_FOUND.toString(),message);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage);
    }
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ErrorMessage> handle(ConstraintViolationException ex){
        Set<ConstraintViolation<?>> violations = ex.getConstraintViolations();
        String message = "";
        for (ConstraintViolation<?> constraintViolation : ex.getConstraintViolations()){
            message = constraintViolation.getMessage();
            break;
        }
        ErrorMessage errorMessage = new ErrorMessage(HttpStatus.NOT_FOUND.toString(),message);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage);
    }
    @ExceptionHandler(UserNotFindException.class)
    public ResponseEntity<ErrorMessage> handle(UserNotFindException ex){
        ErrorMessage errorMessage = new ErrorMessage(HttpStatus.NOT_FOUND.toString(), ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
    }

}
