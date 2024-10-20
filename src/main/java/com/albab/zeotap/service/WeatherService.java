package com.albab.zeotap.service;



import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {

    @Value("${weather.api.url}")
    private String apiUrl;

    @Value("${weather.api.key}")
    private String apiKey;

    private final RestTemplate restTemplate = new RestTemplate();

    public String getWeatherForCity(String city) {
        String url = apiUrl
                .replace("{city}", city)
                .replace("{key}", apiKey);
        
        return restTemplate.getForObject(url, String.class);
    }
}
