package com.ing.weather.enums;

import org.springframework.http.HttpStatus;

public enum ErrorCode {

    DEFAULT("An exception occurred.", HttpStatus.INTERNAL_SERVER_ERROR),
    CITY_NOT_FOUND("City not found.", HttpStatus.NOT_FOUND);

    private final String definition;
    private final HttpStatus httpStatus;

    ErrorCode(String definition, HttpStatus httpStatus) {
        this.definition = definition;
        this.httpStatus = httpStatus;
    }

    public String getDefinition() {
        return definition;
    }

    public HttpStatus getHttpStatus() {
        return this.httpStatus;
    }
}
