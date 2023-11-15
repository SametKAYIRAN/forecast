package com.ing.weather.dto.openweather.location;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OpenLocationResponseDto {
    @JsonProperty(value = "local_names")
    HashMap<String, String> localNames;
    private String name;
    private float lat;
    private float lon;
    private String country;
    private String state;
}
