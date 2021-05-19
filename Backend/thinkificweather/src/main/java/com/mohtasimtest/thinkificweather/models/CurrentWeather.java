package com.mohtasimtest.thinkificweather.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CurrentWeather {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cityName;
    private Integer cityIdentifier;
    private Long timezone;
    private String countryCode;
    private Long sunrise;
    private Long sunset;
    private Long dt;
    private Double windSpeed;
    private Double windDeg;
    private Double windGust;
    private Integer humidity;
    private Integer pressure;
    private Double currentTemperatureFeelsLike;
    private Double temperature;

    public CurrentWeather() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public Integer getCityIdentifier() {
        return cityIdentifier;
    }

    public void setCityIdentifier(Integer cityIdentifier) {
        this.cityIdentifier = cityIdentifier;
    }

    public Long getTimezone() {
        return timezone;
    }

    public void setTimezone(Long timezone) {
        this.timezone = timezone;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public Long getSunrise() {
        return sunrise;
    }

    public void setSunrise(Long sunrise) {
        this.sunrise = sunrise;
    }

    public Long getSunset() {
        return sunset;
    }

    public void setSunset(Long sunset) {
        this.sunset = sunset;
    }

    public Long getDt() {
        return dt;
    }

    public void setDt(Long dt) {
        this.dt = dt;
    }

    public Double getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(Double windSpeed) {
        this.windSpeed = windSpeed;
    }

    public Double getWindDeg() {
        return windDeg;
    }

    public void setWindDeg(Double windDeg) {
        this.windDeg = windDeg;
    }

    public Double getWindGust() {
        return windGust;
    }

    public void setWindGust(Double windGust) {
        this.windGust = windGust;
    }

    public Integer getHumidity() {
        return humidity;
    }

    public void setHumidity(Integer humidity) {
        this.humidity = humidity;
    }

    public Integer getPressure() {
        return pressure;
    }

    public void setPressure(Integer pressure) {
        this.pressure = pressure;
    }

    public Double getCurrentTemperatureFeelsLike() {
        return currentTemperatureFeelsLike;
    }

    public void setCurrentTemperatureFeelsLike(Double currentTemperatureFeelsLike) {
        this.currentTemperatureFeelsLike = currentTemperatureFeelsLike;
    }

    public Double getTemperature() {
        return temperature;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }
}
