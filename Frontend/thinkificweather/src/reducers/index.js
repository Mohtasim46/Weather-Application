import { combineReducers } from "redux"
import errorreducer from "./errorreducer"
import securityreducer from "./securityreducer";
import weatherreducer from "./weatherreducer"


export default combineReducers({
    weather: weatherreducer,
    errors: errorreducer,
    security: securityreducer,
});