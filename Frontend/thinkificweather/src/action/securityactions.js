import axios from 'axios'
import { GET_ERRORS, SET_CURRENT_USER } from "./types";
import jwt_decode from 'jwt-decode';
import setJwtToken from '../securityutils/setjwttoken'

export const createNewCustomer = (newCustomer, history) => async dispatch => {
    try {
        await axios.post("/api/customers/register", newCustomer);
        history.push("/login");
        dispatch({
            type: GET_ERRORS,
            payload: {}
        });
    } catch (error) {
        dispatch({
            type: GET_ERRORS,
            payload: error.response.data
        });
    }
};

export const customerLogin = LoginRequest => async dispatch => {
    try {
        const res = await axios.post("/api/customers/login", LoginRequest);
        const {token} = res.data;
        localStorage.setItem("jwtToken", token);
        setJwtToken(token);
        const decoded = jwt_decode(token);
        dispatch({
            type: SET_CURRENT_USER,
            payload: decoded
        })   
        } catch (error) {
            
            dispatch({
                type: GET_ERRORS,
                payload: error.response.data
            })
        }
}

export const logout = () => dispatch => {
    localStorage.removeItem("jwtToken");
    setJwtToken(false);
    dispatch({
        type: SET_CURRENT_USER,
        payload: {}
    })  
}