package com.mohtasimtest.thinkificweather.repositories;

import com.mohtasimtest.thinkificweather.models.City;
import org.springframework.data.repository.CrudRepository;

public interface CityRepository extends CrudRepository<City, Long> {

    City findByCityName(String cityName);
}
