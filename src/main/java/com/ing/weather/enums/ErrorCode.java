package com.ing.weather.enums;

import org.springframework.http.HttpStatus;

public enum ErrorCode {

    DEFAULT("An exception occurred.", HttpStatus.INTERNAL_SERVER_ERROR),
    CITY_NOT_FOUND("City not found.", HttpStatus.NOT_FOUND),
    MAX_TEMPERATURE_NOT_FOUND("Max temperature not found.", HttpStatus.NOT_FOUND),
    MAX_FEELS_LIKE_NOT_FOUND("Max feels like not found.", HttpStatus.NOT_FOUND),
    MAX_HUMIDITY_NOT_FOUND("Max humidity not found.", HttpStatus.NOT_FOUND);

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
