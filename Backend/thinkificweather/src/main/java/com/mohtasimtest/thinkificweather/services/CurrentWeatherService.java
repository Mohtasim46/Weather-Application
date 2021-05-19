package com.mohtasimtest.thinkificweather.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mohtasimtest.thinkificweather.models.CurrentWeather;
import com.mohtasimtest.thinkificweather.repositories.CurrentWeatherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import static com.mohtasimtest.thinkificweather.contracts.ApiContracts.API_KEY;
import static com.mohtasimtest.thinkificweather.contracts.ApiContracts.UNIT;
import static com.mohtasimtest.thinkificweather.contracts.WeatherContracts.*;

@Service
public class CurrentWeatherService {

    @Autowired
    private CurrentWeatherRepository currentWeatherRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private CurrentWeatherServiceHelper currentWeatherServiceHelper;



    public CurrentWeather getCurrentWeather(String cityName) {
        // We could use a url builder to have this url !!
        String url = "http://api.openweathermap.org/data/2.5/weather?q=" + cityName + "&appid=" + API_KEY + "&units=" + UNIT;

        try {
            ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
            ObjectMapper mapper = new ObjectMapper();
            JsonNode rootNode = mapper.readTree(response.getBody());
            CurrentWeather currentWeather = new CurrentWeather();
            currentWeatherServiceHelper.mapResponseToCurrentWeatherPOJO(currentWeather, rootNode);

            return currentWeather;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return null;
    }

}
