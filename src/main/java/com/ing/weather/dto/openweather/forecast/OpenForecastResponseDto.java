package com.ing.weather.dto.openweather.forecast;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OpenForecastResponseDto {
    List<OpenForecastDataDto> hourly = new ArrayList<>();
    private float lat;
    private float lon;
    private String timezone;
    @JsonProperty("timezone_offset")
    private float timezoneOffset;
}
