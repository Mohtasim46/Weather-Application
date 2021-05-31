import axios from 'axios'
import { GET_ERRORS, GET_WEATHER } from './types';

export const getCurrentWeather = (city) => async dispatch => {
    try {
        console.log('axios calling for city weather - ' + city);
        const response = await axios.get(`/api/weather/${city}`)
        dispatch({
            type: GET_WEATHER,
            payload: response.data
        });
        dispatch({
            type: GET_ERRORS,
            payload: {}
          });
    } catch (error) {
        dispatch({
            type: GET_ERRORS,
            payload: error.response.data
        });
        dispatch({
            type: GET_WEATHER,
            payload: {}
          });
    }
    
}