package com.ing.weather.dto.openweather.forecast;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OpenForecastWeatherDto {
    private float id;
    private String main;
    private String description;
    private String icon;
}
