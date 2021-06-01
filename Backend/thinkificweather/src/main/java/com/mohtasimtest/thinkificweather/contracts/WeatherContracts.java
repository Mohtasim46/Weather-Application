package com.mohtasimtest.thinkificweather.contracts;

public class WeatherContracts {
    public static final String CITY_NAME = "name";
    public static final String CITY_IDETIFIER = "id";
    public static final String TIMEZONE = "timezone";


    public static final String SYSTEM = "sys";
    // These are grouped under sys in openmap response
    public static final String COUNTRY_CODE = "country";
    public static final String SUNRISE = "sunrise";
    public static final String SUNSET = "sunset";

    public static final String DATETIME = "dt";

    public static final String WIND = "wind";
    // These are grouped under WIND in openmap response
    public static final String WIND_SPEED = "speed";
    public static final String WIND_DEG = "deg";
    public static  final String WIND_GUST = "gust";

    public static final String VISIBILITY = "visibility";

    public static final String MAIN = "main";
    // These are grouped under "main" in openmap response
    public static final String HUMIDITY = "humidity";
    public static final String PRESSURE = "pressure";
    public static final String CURRENT_TEMPERATURE_FEELS_LIKE = "feels_like";
    public static final String TEMPERATURE  = "temp";

    public static final String WEATHER = "weather";
    // There are grouped under "weather" in openmap response
    public static final String WEATHER_MAIN = "main";
    public static final String WEATHER_DESCRIPTION = "description";
    public static final String WEATHER_ICON = "icon";


}
