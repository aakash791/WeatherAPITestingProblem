package com.weatherapi.weatherapputility;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class DataInfo {

    @JsonProperty("main")
    private TempInfo tempInfo;

    @JsonProperty("weather")
    private List<WeatherInfo> weatherInfo = new ArrayList<>();;

    @JsonProperty("dt_txt")
    private String dateTime;

    @JsonProperty("main")
    public TempInfo getTempInfo() {
        return tempInfo;
    }

    @JsonProperty("main")
    public void setTempInfo(TempInfo tempInfo) {
        this.tempInfo = tempInfo;
    }

    @JsonProperty("weather")
    public List<WeatherInfo> getWeatherInfo() {
        return weatherInfo;
    }

    @JsonProperty("weather")
    public void setWeatherInfo(List<WeatherInfo> weatherInfo) {
        this.weatherInfo = weatherInfo;
    }

    @JsonProperty("dt_txt")
    public String getDateTime() {
        return dateTime;
    }

    @JsonProperty("dt_txt")
    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    @Override
    public String toString() {
        return "DataInfo{" +
                "tempInfo=" + tempInfo +
                ", weatherInfo=" + weatherInfo +
                ", dateTime='" + dateTime + '\'' +
                '}';
    }
}
