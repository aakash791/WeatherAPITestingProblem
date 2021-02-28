package com.weatherapi.weatherapputility;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class WeatherData {

    @JsonProperty("cod")
    private String apiCode;

    @JsonProperty("message")
    private String apiMessage;

    @JsonProperty("cnt")
    private int totalTimestamps;

    @JsonProperty("list")
    private List<DataInfo> dataInfo = new ArrayList<>();

    @JsonProperty("list")
    public List<DataInfo> getDataInfo() {
        return dataInfo;
    }

    @JsonProperty("list")
    public void setDataInfo(List<DataInfo> dataInfo) {
        this.dataInfo = dataInfo;
    }

    @JsonProperty("cod")
    public String getApiCode() {
        return apiCode;
    }

    @JsonProperty("cod")
    public void setApiCode(String apiCode) {
        this.apiCode = apiCode;
    }

    @JsonProperty("message")
    public String getApiMessage() {
        return apiMessage;
    }

    @JsonProperty("message")
    public void setApiMessage(String apiMessage) {
        this.apiMessage = apiMessage;
    }

    @JsonProperty("cnt")
    public int getTotalTimestamps() {
        return totalTimestamps;
    }

    @JsonProperty("cnt")
    public void setTotalTimestamps(int totalTimestamps) {
        this.totalTimestamps = totalTimestamps;
    }

    @Override
    public String toString() {
        return "WeatherData{" +
                "apiCode='" + apiCode + '\'' +
                ", apiMessage='" + apiMessage + '\'' +
                ", totalTimestamps=" + totalTimestamps +
                ", dataInfo=" + dataInfo +
                '}';
    }
}
