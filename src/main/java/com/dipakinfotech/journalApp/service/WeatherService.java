package com.dipakinfotech.journalApp.service;

import com.dipakinfotech.journalApp.apiResponce.WeatherResponce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class WeatherService {
    private static final String apiKey = "4e0f5ee0ff2e7399b33dea1632440101";
    private static final String API = "http://api.weatherstack.com/current?access_key=API_KEY&query=CITY";

    @Autowired
    private RestTemplate restTemplate;
    
    public WeatherResponce getWeather(String city) {
        String finalAPI = API.replace("CITY", city).replace("API_KEY", apiKey);
        ResponseEntity<WeatherResponce> response = restTemplate.exchange(finalAPI, HttpMethod.GET, null, WeatherResponce.class);
        WeatherResponce body = response.getBody();
        return body;
    }
}
