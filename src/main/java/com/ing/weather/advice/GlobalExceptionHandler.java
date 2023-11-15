package com.ing.weather.advice;

import com.ing.weather.enums.ErrorCode;
import com.ing.weather.exception.BusinessException;
import com.ing.weather.exception.ErrorMessage;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDate;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<ErrorMessage> businessExceptionHandler(BusinessException ex) {
        return new ResponseEntity<>(ErrorMessage.builder()
                .description(ex.getMessage())
                .timestamp(LocalDate.now())
                .build(), ex.getHttpStatus());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorMessage> exceptionHandler(Exception ex) {
        return new ResponseEntity<>(ErrorMessage.builder()
                .description(ErrorCode.DEFAULT.getDefinition())
                .timestamp(LocalDate.now())
                .build(), ErrorCode.DEFAULT.getHttpStatus());
    }

}
