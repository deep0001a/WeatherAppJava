package com.WeatherForcast.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WeatherController {

    @Autowired
    private WeatherService weatherService;

    @GetMapping("/Weather")
    public Weather getWeather(@RequestParam String city) {
        return weatherService.getWeatherByCity(city);
    }
}
