package com.mohtasimtest.thinkificweather.repositories;

import com.mohtasimtest.thinkificweather.models.CurrentWeather;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurrentWeatherRepository extends CrudRepository<CurrentWeather, Long> {

    CurrentWeather getWeatherByCityName(String cityName);
}
