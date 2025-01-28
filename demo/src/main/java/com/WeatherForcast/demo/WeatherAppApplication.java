package com.WeatherForcast.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WeatherAppApplication {


	@SpringBootApplication
	public static class WeatherInfoApplication {
		public static void main(String[] args) {
			SpringApplication.run(WeatherInfoApplication.class, args);
		}
	}
}




