import { createStore, applyMiddleware, compose } from "redux";
import thunk from "redux-thunk";
import reducer from "./reducers/index";

const initialState = {};
const middleware = [thunk];

let store;

let REACTREDUX_DEVTOOLS = window.__REDUX_DEVTOOLS_EXTENSION__ &&
window.__REDUX_DEVTOOLS_EXTENSION__()

if (window.navigator.userAgent.includes("Chrome") && REACTREDUX_DEVTOOLS) {
  store = createStore(
    reducer,
    initialState,
    compose(
      applyMiddleware(...middleware),
      REACTREDUX_DEVTOOLS
    )
  );
} else {
  store = createStore(
    reducer,
    initialState,
    compose(applyMiddleware(...middleware))
  );
}

export default store;