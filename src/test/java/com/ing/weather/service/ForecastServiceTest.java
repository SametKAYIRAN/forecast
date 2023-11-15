package com.ing.weather.service;

import com.ing.weather.dto.forecast.ForecastDataDto;
import com.ing.weather.dto.openweather.forecast.OpenForecastDataDto;
import com.ing.weather.dto.openweather.forecast.OpenForecastResponseDto;
import com.ing.weather.dto.openweather.location.OpenLocationResponseDto;
import com.ing.weather.enums.ErrorCode;
import com.ing.weather.exception.BusinessException;
import com.ing.weather.feign.openweather.forecast.OpenForecastFeignClient;
import com.ing.weather.feign.openweather.location.OpenLocationFeignClient;
import com.ing.weather.mapper.ForecastDataDtoMapperImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.given;


@ExtendWith(MockitoExtension.class)
class ForecastServiceTest {

    @InjectMocks
    private ForecastService forecastService;
    @Mock
    private OpenLocationFeignClient openLocationFeignClient;
    @Mock
    private OpenForecastFeignClient openForecastFeignClient;
    @Spy
    private ForecastDataDtoMapperImpl forecastDataDtoMapper;


    @Test
    void givenCityNotExist_whenGetForecast_willThrowCityNotFoundException() {
        //given
        String cityName = "not exist";
        String expectedMessage = ErrorCode.CITY_NOT_FOUND.getDefinition();
        given(openLocationFeignClient.getLocations(cityName)).willReturn(new ArrayList<>());

        //when
        BusinessException result = assertThrows(BusinessException.class, () -> forecastService.getForecast(cityName));

        //then
        assertThat(result).hasMessage(expectedMessage);
    }

    @Test
    void givenExistingCity_whenGetForecast_willReturnForecast() {
        //given
        String cityName = "london";
        float cityLat = 1.0f;
        float cityLon = 2.0f;
        float expectedFeelsLike = 100f;
        float expectedMaximum = 150f;
        float expectedHumidity = 200f;

        OpenLocationResponseDto openLocationResponseDto = OpenLocationResponseDto.builder()
                .country(cityName)
                .lat(cityLat)
                .lon(cityLon).build();

        OpenForecastDataDto openForecastDataDto = OpenForecastDataDto.builder()
                .feelsLike(expectedFeelsLike)
                .humidity(expectedHumidity)
                .temp(expectedMaximum).build();

        OpenForecastResponseDto openForecastResponseDto = OpenForecastResponseDto.builder()
                .hourly(List.of(openForecastDataDto)).build();

        given(openLocationFeignClient.getLocations(cityName)).willReturn(List.of(openLocationResponseDto));
        given(openForecastFeignClient.getForecast(cityLat, cityLon)).willReturn(openForecastResponseDto);

        //when
        ForecastDataDto result = forecastService.getForecast(cityName).get(0);

        //then
        assertThat(result.getFeelsLike()).isEqualTo(expectedFeelsLike);
        assertThat(result.getHumidity()).isEqualTo(expectedHumidity);
        assertThat(result.getMaximum()).isEqualTo(expectedMaximum);
    }

}