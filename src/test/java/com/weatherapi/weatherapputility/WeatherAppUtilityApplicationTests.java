package com.weatherapi.weatherapputility;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.text.ParseException;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class WeatherAppUtilityApplicationTests {

    @Test
    void testTemperature0Days() throws ParseException, IOException, URISyntaxException {

        ObjectMapper objectMapper = new ObjectMapper();
        WeatherData weatherData = objectMapper.readValue(new File( getClass().getResource("/TestInputs/weather1su0temp.json").toURI()), WeatherData.class);
        Forecaster forecaster  = new ForecastTemperature();
        int result = forecaster.findNumberOfDays(weatherData);

        assertEquals(result, 0);
    }

    @Test
    void testTemperature2Days() throws ParseException, IOException, URISyntaxException {

        ObjectMapper objectMapper = new ObjectMapper();
        WeatherData weatherData = objectMapper.readValue(new File(getClass().getResource("/TestInputs/weather2su2temp.json").toURI()), WeatherData.class);
        Forecaster forecaster  = new ForecastTemperature();
        int result = forecaster.findNumberOfDays(weatherData);

        assertEquals(result, 2);
    }

    @Test
    void testWeather1SunnyDays() throws ParseException, IOException, URISyntaxException {

        ObjectMapper objectMapper = new ObjectMapper();
        WeatherData weatherData = objectMapper.readValue(new File(getClass().getResource("/TestInputs/weather1su0temp.json").toURI()), WeatherData.class);
        Forecaster forecaster  = new ForecastWeather();
        int result = forecaster.findNumberOfDays(weatherData);

        assertEquals(result, 1);
    }

    @Test
    void testWeather2SunnyDays() throws ParseException, IOException, URISyntaxException {

        ObjectMapper objectMapper = new ObjectMapper();
        WeatherData weatherData = objectMapper.readValue(new File(getClass().getResource("/TestInputs/weather2su2temp.json").toURI()), WeatherData.class);
        Forecaster forecaster  = new ForecastWeather();
        int result = forecaster.findNumberOfDays(weatherData);

        assertEquals(result, 2);
    }

}
