package com.ing.weather.mapper;

import com.ing.weather.dto.forecast.ForecastDataDto;
import com.ing.weather.dto.openweather.forecast.OpenForecastDataDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ForecastDataDtoMapper {

    @Mapping(source = "temp", target = "maximum")
    ForecastDataDto convert(OpenForecastDataDto openForecastDataDto);

    List<ForecastDataDto> convert(List<OpenForecastDataDto> openForecastDataDtoList);
}


