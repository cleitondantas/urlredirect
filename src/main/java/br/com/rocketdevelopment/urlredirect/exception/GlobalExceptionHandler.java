package br.com.rocketdevelopment.urlredirect.exception;


import lombok.extern.java.Log;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Log
public class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> notFoundException(RuntimeException e){
        log.severe(e.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("URL not found");
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<String> notValidException(MethodArgumentNotValidException e){
        log.severe(e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid URL");
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> notValidException(Exception e){
        log.severe(e.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal server error");
    }

}
