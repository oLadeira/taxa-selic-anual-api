package br.com.lucasladeira.taxaselicanualapi.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolationException;
import java.time.LocalDateTime;

@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(APINotAvaliableException.class)
    public ResponseEntity<StandardErrorBody> apiNotAvaliableException(APINotAvaliableException ex, HttpServletRequest request){
        StandardErrorBody error = new StandardErrorBody(
                HttpStatus.SERVICE_UNAVAILABLE.value(),
                ex.getMessage(),
                System.currentTimeMillis()
        );
        return ResponseEntity.status(error.getStatus()).body(error);
    }

    @ExceptionHandler(SelicNotFoundException.class)
    public ResponseEntity<StandardErrorBody> selicNotFoundException(SelicNotFoundException ex, HttpServletRequest request){
        StandardErrorBody error = new StandardErrorBody(
                HttpStatus.NOT_FOUND.value(),
                ex.getMessage(),
                System.currentTimeMillis()
        );
        return ResponseEntity.status(error.getStatus()).body(error);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<StandardErrorBody> constraintViolationException(ConstraintViolationException ex, HttpServletRequest request){
        StandardErrorBody error = new StandardErrorBody(
                HttpStatus.NOT_FOUND.value(),
                ex.getLocalizedMessage(),
                System.currentTimeMillis()
        );
        return ResponseEntity.status(error.getStatus()).body(error);
    }
}
