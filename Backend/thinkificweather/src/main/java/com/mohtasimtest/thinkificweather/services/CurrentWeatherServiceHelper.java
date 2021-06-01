package com.mohtasimtest.thinkificweather.services;

import com.fasterxml.jackson.databind.JsonNode;
import com.mohtasimtest.thinkificweather.models.City;
import com.mohtasimtest.thinkificweather.models.CurrentWeather;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.time.Instant;

import static com.mohtasimtest.thinkificweather.contracts.ApiContracts.NO_UPDATE_TIME;
import static com.mohtasimtest.thinkificweather.contracts.WeatherContracts.*;
import static com.mohtasimtest.thinkificweather.contracts.WeatherContracts.TEMPERATURE;

@Component
public class CurrentWeatherServiceHelper {

    public void mapResponseToCurrentWeatherPOJO(CurrentWeather currentWeather, JsonNode rootNode) {
        currentWeather.setWeatherMain(rootNode.path(WEATHER).get(0).path(WEATHER_MAIN).asText());
        currentWeather.setWeatherDescription(rootNode.path(WEATHER).get(0).path(WEATHER_DESCRIPTION).asText());
        currentWeather.setWeatherIcon(rootNode.path(WEATHER).get(0).path(WEATHER_ICON).asText());

        currentWeather.setCityName(rootNode.path(CITY_NAME).asText());
        currentWeather.setCityIdentifier(rootNode.path(CITY_IDETIFIER).asInt());
        currentWeather.setTimezone(rootNode.path(TIMEZONE).asLong());

        currentWeather.setCountryCode(rootNode.path(SYSTEM).path(COUNTRY_CODE).asText());
        currentWeather.setSunrise(rootNode.path(SYSTEM).path(SUNRISE).asLong());
        currentWeather.setSunset(rootNode.path(SYSTEM).path(SUNSET).asLong());

        currentWeather.setDt(rootNode.path(DATETIME).asLong());

        currentWeather.setWindSpeed(rootNode.path(WIND).path(WIND_SPEED).asDouble());
        currentWeather.setWindDeg(rootNode.path(WIND).path(WIND_DEG).asDouble());
        currentWeather.setWindGust(rootNode.path(WIND).path(WIND_GUST).asDouble());

        currentWeather.setVisibility(rootNode.path(VISIBILITY).asInt());

        currentWeather.setHumidity(rootNode.path(MAIN).path(HUMIDITY).asInt());
        currentWeather.setPressure(rootNode.path(MAIN).path(PRESSURE).asInt());
        currentWeather.setCurrentTemperatureFeelsLike(rootNode.path(MAIN).path(CURRENT_TEMPERATURE_FEELS_LIKE).asDouble());
        currentWeather.setTemperature(rootNode.path(MAIN).path(TEMPERATURE).asDouble());
    }

    public boolean isAlreadyUpdatedWithinTimeRange(Long lastUpdated) {
        Long currentTime = Instant.now().getEpochSecond();
        System.out.println(lastUpdated + " : " + currentTime);
        LoggerFactory.getLogger(CurrentWeatherServiceHelper.class).info("The updated times {} -- {}", currentTime, lastUpdated);
        if(currentTime - lastUpdated < NO_UPDATE_TIME) {
            return true;
        } else return false;
    }

    public City getCityEntity(CurrentWeather currentWeather) {
        City city = new City();
        city.setCityName(currentWeather.getCityName());
        city.setCityIdentifier(currentWeather.getCityIdentifier());
        city.setLastQueried(currentWeather.getDt());
        city.setCountryCode(currentWeather.getCountryCode());

        return city;
    }
}
