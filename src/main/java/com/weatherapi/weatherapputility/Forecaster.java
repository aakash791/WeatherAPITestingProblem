package com.weatherapi.weatherapputility;

import java.text.ParseException;

public abstract class Forecaster {

    int forDays=5;
    float tempLimit=20;

    public String getAPIURL(String city, String units, String appid){
        return "http://api.openweathermap.org/data/2.5/forecast?q="+city+"&units="+units+"&appId="+appid;
    }

    public abstract int findNumberOfDays(WeatherData weatherData) throws ParseException;

}
