package com.mohtasimtest.thinkificweather.controllers;

import com.mohtasimtest.thinkificweather.models.CurrentWeather;
import com.mohtasimtest.thinkificweather.services.CurrentWeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/weather")
public class CurrentWeatherController {

    @Autowired
    private CurrentWeatherService currentWeatherService;

    @GetMapping("/{cityName}")
    public ResponseEntity<?> getCurrentWeatherByCity(@PathVariable String cityName) {

        CurrentWeather currentWeather = currentWeatherService.getCurrentWeather(cityName);

        return new ResponseEntity<CurrentWeather>(currentWeather, HttpStatus.OK);
    }
}
