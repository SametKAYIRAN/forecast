package com.ing.weather.service;

import com.ing.weather.dto.forecast.ForecastDataDto;
import com.ing.weather.dto.openweather.forecast.OpenForecastResponseDto;
import com.ing.weather.dto.openweather.location.OpenLocationResponseDto;
import com.ing.weather.enums.ErrorCode;
import com.ing.weather.exception.BusinessException;
import com.ing.weather.feign.openweather.forecast.OpenForecastFeignClient;
import com.ing.weather.feign.openweather.location.OpenLocationFeignClient;
import com.ing.weather.mapper.ForecastDataDtoMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ForecastService {

    private final OpenLocationFeignClient openLocationFeignClient;
    private final OpenForecastFeignClient openForecastFeignClient;
    private final ForecastDataDtoMapper forecastDataDtoMapper;

    public List<ForecastDataDto> getForecast(String cityName) {

        OpenLocationResponseDto location = this.getLocation(cityName).orElseThrow(() -> {
            throw new BusinessException(ErrorCode.CITY_NOT_FOUND);
        });
        OpenForecastResponseDto forecast = openForecastFeignClient.getForecast(location.getLat(), location.getLon());
        return forecastDataDtoMapper.convert(forecast.getHourly());
    }

    private Optional<OpenLocationResponseDto> getLocation(String cityName) {
        List<OpenLocationResponseDto> locations = openLocationFeignClient.getLocations(cityName);
        if (locations.isEmpty()) {
            return Optional.empty();
        } else {
            return Optional.of(locations.get(0));
        }
    }

}
