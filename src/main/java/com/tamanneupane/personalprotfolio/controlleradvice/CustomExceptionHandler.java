package com.tamanneupane.personalprotfolio.controlleradvice;

import com.tamanneupane.personalprotfolio.exceptions.ServiceNotFoundException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;

@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(ServiceNotFoundException.class)
    public ResponseEntity<HashMap<String, Object>> handleServiceNotFoundException(ServiceNotFoundException serviceNotFoundException){
        HashMap<String, Object> response = new HashMap<>();
        response.put("status", serviceNotFoundException.getStatusCode());
        response.put("message", serviceNotFoundException.getMessage());
        return ResponseEntity.ok(response);
    }

    @ExceptionHandler(EmptyResultDataAccessException.class)
    public ResponseEntity<HashMap<String, Object>> handleEmptyResultDataAccessException(EmptyResultDataAccessException emptyResultDataAccessException){
        HashMap<String, Object> response = new HashMap<>();
        response.put("status", 404);
        response.put("message", emptyResultDataAccessException.getMessage());
        return ResponseEntity.ok(response);
    }
}
