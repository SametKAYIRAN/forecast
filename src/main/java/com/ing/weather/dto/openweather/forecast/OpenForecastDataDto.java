package com.ing.weather.dto.openweather.forecast;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OpenForecastDataDto {

    ArrayList<OpenForecastWeatherDto> weather = new ArrayList<>();
    @JsonProperty(value = "feels_like")
    private float feelsLike;
    private float temp;
    private float dt;
    private float pressure;
    private float humidity;
    @JsonProperty(value = "dew_point")
    private float dewPoint;
    private float uvi;
    private float clouds;
    private float visibility;
    @JsonProperty(value = "wind_speed")
    private float windSpeed;
    @JsonProperty(value = "wind_deg")
    private float windDeg;
    @JsonProperty(value = "wind_gust")
    private float windGust;
    private float pop;
}
