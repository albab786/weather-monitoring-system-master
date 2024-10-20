package com.albab.zeotap.service;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class WeatherProcessor {

    private final ObjectMapper objectMapper = new ObjectMapper();
    private final Map<String, DailySummary> dailySummaries = new HashMap<>();

    public void processWeatherData(String city, String response) throws Exception {
        JsonNode rootNode = objectMapper.readTree(response);

        String mainCondition = rootNode.path("weather").get(0).path("main").asText();
        double temp = rootNode.path("main").path("temp").asDouble();
        long timestamp = rootNode.path("dt").asLong();

        updateDailySummary(city, temp, mainCondition);
    }

    private void updateDailySummary(String city, double temp, String mainCondition) {
        DailySummary summary = dailySummaries.getOrDefault(city, new DailySummary());

        summary.update(temp, mainCondition);

        dailySummaries.put(city, summary);
    }
}
