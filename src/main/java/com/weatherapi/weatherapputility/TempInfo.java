package com.weatherapi.weatherapputility;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TempInfo {

    @JsonProperty("temp")
    private float tempDay;

    @JsonProperty("temp_min")
    private float tempMin;

    @JsonProperty("temp_max")
    private float tempMax;

    @JsonProperty("feels_like")
    private float feelsLike;

    public float getTempDay() {
        return tempDay;
    }

    public void setTempDay(float tempDay) {
        this.tempDay = tempDay;
    }

    public float getTempMin() {
        return tempMin;
    }

    public void setTempMin(float tempMin) {
        this.tempMin = tempMin;
    }

    public float getTempMax() {
        return tempMax;
    }

    public void setTempMax(float tempMax) {
        this.tempMax = tempMax;
    }

    public float getFeelsLike() {
        return feelsLike;
    }

    public void setFeelsLike(float feelsLike) {
        this.feelsLike = feelsLike;
    }

    @Override
    public String toString() {
        return "TempInfo{" +
                "tempDay=" + tempDay +
                ", tempMin=" + tempMin +
                ", tempMax=" + tempMax +
                ", feelsLike=" + feelsLike +
                '}';
    }
}
