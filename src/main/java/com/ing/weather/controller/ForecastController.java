package com.ing.weather.controller;

import com.ing.weather.dto.forecast.ForecastDataDto;
import com.ing.weather.service.ForecastService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/forecast")
@AllArgsConstructor
public class ForecastController {

    private final ForecastService forecastService;

    @GetMapping
    public ResponseEntity<List<ForecastDataDto>> getForecast(@RequestParam String cityName) {
        return ResponseEntity.ok().body(forecastService.getForecast(cityName));
    }
}
