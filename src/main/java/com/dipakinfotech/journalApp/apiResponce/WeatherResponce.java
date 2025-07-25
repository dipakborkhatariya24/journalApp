package com.dipakinfotech.journalApp.apiResponce;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class WeatherResponce {

    public Current current;

    @Getter
    @Setter
    public class Current {

        public int temperature;

        @JsonProperty("weather_descriptions")
        public List<String> weather_descriptions;

        public int feelslike;

    }
}