package com.albab.zeotap.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.albab.zeotap.service.WeatherService;

@RestController
public class WeatherController {

    @Autowired
    private WeatherService weatherService;

    @GetMapping("/api/weather")
    public String getWeather(@RequestParam String city) {
        return weatherService.getWeatherForCity(city);
    }
}
