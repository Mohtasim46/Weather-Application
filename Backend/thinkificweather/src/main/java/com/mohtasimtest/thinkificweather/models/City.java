package com.mohtasimtest.thinkificweather.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cityName;
    private Integer cityIdentifier;
    private String countryCode;
    private Long lastQueried;

    public City() {
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

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public Long getLastQueried() {
        return lastQueried;
    }

    public void setLastQueried(Long lastQueried) {
        this.lastQueried = lastQueried;
    }
}
