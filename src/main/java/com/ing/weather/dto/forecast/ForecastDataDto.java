package com.ing.weather.dto.forecast;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ForecastDataDto {

    private float maximum;
    private float feelsLike;
    private float humidity;
}
