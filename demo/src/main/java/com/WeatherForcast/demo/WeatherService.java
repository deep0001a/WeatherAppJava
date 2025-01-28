package com.WeatherForcast.demo;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {
    private static final String API_URL =
            "https://api.openweathermap.org/data/2.5/weather?q=London&appid=f7f8b77c8a0ad5342c40bca68bb3e183";
    private static final String API_KEY = "f7f8b77c8a0ad5342c40bca68bb3e183"; // Replace with your API key

    public Weather getWeatherByCity(String city) {
        RestTemplate restTemplate = new RestTemplate();

        // Fetch API response
        WeatherApiResponse response = restTemplate.getForObject(API_URL, WeatherApiResponse.class, city, API_KEY);

        // Map API response to Weather object
        return new Weather(
                city,
                response.getMain().getTemp(),
                response.getMain().getHumidity(),
                response.getWind().getSpeed()
        );
    }
}
