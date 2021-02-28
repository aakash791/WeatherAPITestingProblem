package com.weatherapi.weatherapputility;

import com.fasterxml.jackson.annotation.JsonProperty;

public class WeatherInfo {

    @JsonProperty("id")
    int wId;

    @JsonProperty("main")
    String wType;

    @JsonProperty("description")
    String wDesc;

    @JsonProperty("icon")
    String wIcon;

    public int getwId() {
        return wId;
    }

    public void setwId(int wId) {
        this.wId = wId;
    }

    public String getwType() {
        return wType;
    }

    public void setwType(String wType) {
        this.wType = wType;
    }

    public String getwDesc() {
        return wDesc;
    }

    public void setwDesc(String wDesc) {
        this.wDesc = wDesc;
    }

    public String getwIcon() {
        return wIcon;
    }

    public void setwIcon(String wIcon) {
        this.wIcon = wIcon;
    }

    @Override
    public String toString() {
        return "weatherInfo{" +
                "wId=" + wId +
                ", wType='" + wType + '\'' +
                ", wDesc='" + wDesc + '\'' +
                ", wIcon='" + wIcon + '\'' +
                '}';
    }
}
