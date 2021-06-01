import React from 'react'
import WeatherWrapper from './styles/weatherwrapper';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import {
  faCloud,
  faBolt,
  faCloudRain,
  faCloudShowersHeavy,
  faSnowflake,
  faSun,
  faSmog,
} from '@fortawesome/free-solid-svg-icons';
import WeatherIcon from './styles/weathericon';
import Description from './styles/description';
import CityTemperature from './styles/citytemperature';
import WeatherDetailsWrapper from './styles/weatherdetailswrapper';
import WeatherDetail from './styles/weatherdetail';
import Text from './styles/text';

const formatAMPM = (date) => {
    let hours = date.getHours();
    let minutes = date.getMinutes();    
    const ampm = (hours >= 12)? 'PM': 'AM';
  
    hours %= 12;
    hours = hours || 12;    
    minutes = minutes < 10 ? `0${minutes}` : minutes;
  
    const strTime = `${hours}:${minutes} ${ampm}`;
  
    return strTime;
};

const getWeatherIcon = (weatherMain) => {

    switch(weatherMain) {
        case 'Thunderstorm':
            return <FontAwesomeIcon icon={faBolt} />
        case 'Drizzle':
            return <FontAwesomeIcon icon={faCloudRain} />
        case 'Rain':
            return <FontAwesomeIcon icon={faCloudShowersHeavy} />
        case 'Snow':
            return <FontAwesomeIcon icon={faSnowflake} />
        case 'Clear':
            return <FontAwesomeIcon icon={faSun} />
        case 'Clouds':
            return <FontAwesomeIcon icon={faCloud} />
        default:
            return <FontAwesomeIcon icon={faSmog} />
    }
}

const Weatherdescription = ({ weather }) => {

    console.log(weather.dt * 1000);
    const localTimeOffset = new Date().getTimezoneOffset()*60;
    console.log(localTimeOffset);
    
    const dateObject = new Date( (weather.dt + localTimeOffset + weather.timezone) * 1000);
    const sunriseObject = new Date( (weather.sunrise + localTimeOffset + weather.timezone) * 1000);
    const sunsetObject = new Date( (weather.sunset + localTimeOffset + weather.timezone) * 1000);

    return (
        <div className='container' >
            <Description>
                {formatAMPM(dateObject)}
            </Description>
            <h2>{weather.cityName}, {weather.countryCode}</h2>
            <WeatherWrapper>
                <WeatherIcon>{getWeatherIcon(weather.weatherMain)}</WeatherIcon>
                <div>
                    <CityTemperature>{Math.floor(weather.temperature)}&#176;</CityTemperature>
                    <Description weight="400" firstToUpperCase>
                        Feels Like {weather.currentTemperatureFeelsLike}&#176;, {weather.weatherMain}, {weather.weatherDescription}
                    </Description>
                </div>
            </WeatherWrapper>
            <WeatherDetailsWrapper>
                <WeatherDetail>
                    <Description align="center" weight="400">
                        {weather.windSpeed}mph
                    </Description>
                    <Text align="center">Wind</Text>
                </WeatherDetail>
                <WeatherDetail>
                    <Description align="center" weight="400">
                        {1.0*weather.visibility/1000.0}km
                    </Description>
                    <Text align="center">Visibility</Text>
                </WeatherDetail>
                <WeatherDetail>
                    <Description align="center" weight="400">
                        {weather.humidity}%
                    </Description>
                    <Text align="center">Humidity</Text>
                </WeatherDetail>
                <WeatherDetail>
                    <Description align="center" weight="400">
                        {weather.pressure}hPa
                    </Description>
                    <Text align="center">Pressure</Text>
                </WeatherDetail>
                <WeatherDetail>
                    <Description align="center" weight="400">
                        {formatAMPM(sunriseObject)}
                    </Description>
                    <Text align="center">Sunrise</Text>
                </WeatherDetail>
                <WeatherDetail>
                    <Description align="center" weight="400">
                        {formatAMPM(sunsetObject)}
                    </Description>
                    <Text align="center">Sunset</Text>
                </WeatherDetail>
            </WeatherDetailsWrapper>

        </div>
    );
}
export default  Weatherdescription;