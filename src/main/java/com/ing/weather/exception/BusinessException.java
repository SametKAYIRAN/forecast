package com.ing.weather.exception;

import com.ing.weather.enums.ErrorCode;
import org.springframework.http.HttpStatus;

import java.io.Serial;

public class BusinessException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 7718828512143293558L;
    private final HttpStatus httpStatus;


    public BusinessException(ErrorCode errorCode) {
        super(errorCode.getDefinition());
        this.httpStatus = errorCode.getHttpStatus();
    }

    public BusinessException(String message, HttpStatus status) {
        super(message);
        this.httpStatus = status;
    }

    public BusinessException(String message) {
        super(message);
        this.httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
    }

    public HttpStatus getHttpStatus() {
        return this.httpStatus;
    }

}
