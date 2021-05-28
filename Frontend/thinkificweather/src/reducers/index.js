import { combineReducers } from "redux"
import errorreducer from "./errorreducer"
import weatherreducer from "./weatherreducer"


export default combineReducers({
    weather: weatherreducer,
    errors: errorreducer,
});