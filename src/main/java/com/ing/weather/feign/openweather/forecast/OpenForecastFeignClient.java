package com.ing.weather.feign.openweather.forecast;

import com.ing.weather.dto.openweather.forecast.OpenForecastResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "OpenWeatherForecastFeignClient", url = "${open-weather-api.urls.forecast.url}")
public interface OpenForecastFeignClient {

    @GetMapping(produces = "application/json", consumes = "application/json")
    OpenForecastResponseDto getForecast(@RequestParam Float lat, @RequestParam Float lon);
}
