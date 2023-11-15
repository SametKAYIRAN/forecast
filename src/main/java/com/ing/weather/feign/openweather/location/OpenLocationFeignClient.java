package com.ing.weather.feign.openweather.location;

import com.ing.weather.dto.openweather.location.OpenLocationResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(value = "OpenWeatherLocationFeignClient", url = "${open-weather-api.urls.location.url}")
public interface OpenLocationFeignClient {

    @GetMapping(produces = "application/json", consumes = "application/json")
    List<OpenLocationResponseDto> getLocations(@RequestParam String q);
}
