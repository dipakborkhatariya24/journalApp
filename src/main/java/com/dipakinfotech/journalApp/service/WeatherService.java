package com.dipakinfotech.journalApp.service;

import com.dipakinfotech.journalApp.apiResponce.WeatherResponce;
import com.dipakinfotech.journalApp.cache.AppCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {

    @Value("${weather.api.key}")
    private String apiKey;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private AppCache appCache;

    @Autowired
    private RedisService redisService;

    public WeatherResponce getWeather(String city) {
        WeatherResponce weatherResponce = redisService.get("weather_of_" + city, WeatherResponce.class);
        if (weatherResponce != null) {
            return weatherResponce;
        } else {
            String finalAPI = appCache.appCache.get(AppCache.keys.WEATHER_API.toString()).replace("<city>", city).replace("<apiKey>", apiKey);
            ResponseEntity<WeatherResponce> response = restTemplate.exchange(finalAPI, HttpMethod.GET, null, WeatherResponce.class);
            WeatherResponce body = response.getBody();
            if (body != null) {
                redisService.set("weather_of_" + city, body, 300l);

            }
            return body;
        }
    }
}
