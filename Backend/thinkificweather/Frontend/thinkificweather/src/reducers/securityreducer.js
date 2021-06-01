import { SET_CURRENT_USER } from '../action/types'

const initialState = {
    user: {},
    validToken: false
}

export default function(state=initialState, action) {
    switch(action.type) {
        case SET_CURRENT_USER:
            return {
                ...state,
                user: action.payload,
                validToken: (action.payload)?true:false,
            };
        default:
            return state;
    }
};