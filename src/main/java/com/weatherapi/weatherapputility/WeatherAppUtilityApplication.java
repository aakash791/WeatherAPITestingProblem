package com.weatherapi.weatherapputility;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.DefaultResponseErrorHandler;
import org.springframework.web.client.RestTemplate;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

@SpringBootApplication
public class WeatherAppUtilityApplication {


    private static final Logger log = LoggerFactory.getLogger(WeatherAppUtilityApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(WeatherAppUtilityApplication.class, args);
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.errorHandler(new DefaultResponseErrorHandler()).build();
    }

    @Bean
    public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
        return args -> {

        Forecaster forecaster  = new ForecastTemperature();
        String url = forecaster.getAPIURL("Sydney","metric","e31102d1d1f4f9efd529b87dc296bda8");

        WeatherData weatherData = restTemplate.getForObject(url, WeatherData.class);

        //TO TEST API RESPONSE- UNCOMMENT BELOW LINE
        //WeatherData [] weatherData = restTemplate.getForObject("http://localhost:3000/data", WeatherData[].class);

        //To store api response to a file
        //ObjectMapper objectMapper = new ObjectMapper();
        //objectMapper.writeValue(new File(getClass().getResource("/testWeatherInput.json").getPath()),weatherData);

        log.info(weatherData.toString());

        forecaster.findNumberOfDays(weatherData);
        forecaster = new ForecastWeather();
        forecaster.findNumberOfDays(weatherData);

        };
    }



}
