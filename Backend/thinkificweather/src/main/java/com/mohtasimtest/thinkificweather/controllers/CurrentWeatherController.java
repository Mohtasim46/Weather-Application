package com.mohtasimtest.thinkificweather.controllers;

import com.mohtasimtest.thinkificweather.exceptions.InvalidCityNameException;
import com.mohtasimtest.thinkificweather.models.CurrentWeather;
import com.mohtasimtest.thinkificweather.services.CurrentWeatherService;
import com.mohtasimtest.thinkificweather.services.ErrorValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/weather")
public class CurrentWeatherController {

    @Autowired
    private CurrentWeatherService currentWeatherService;

    @Autowired
    private ErrorValidationService errorValidationService;

    @GetMapping("/{cityName}")
    public ResponseEntity<?> getCurrentWeatherByCity(@PathVariable String cityName) {

        CurrentWeather currentWeather = currentWeatherService.getCurrentWeather(cityName);

        return new ResponseEntity<CurrentWeather>(currentWeather, HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<?> getWeather() {
        throw new InvalidCityNameException("Please type in a valid city name.");
    }


}
