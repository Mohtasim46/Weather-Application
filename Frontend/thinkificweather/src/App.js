
import Header from './components/header';
import {BrowserRouter as Router, Route, Switch} from 'react-router-dom';
import "bootstrap/dist/css/bootstrap.min.css";
import Dashboard from './pages/dashboard';
import { Provider } from 'react-redux';
import store from './store';
import Register from './pages/register';
import Login from './pages/login';
import SecuredRoute from './securityutils/securedroute';
import Landingpage from './pages/landingpage';
import setJwtToken from './securityutils/setjwttoken';
import jwt_decode from 'jwt-decode';
import { logout } from './action/securityactions';
import { SET_CURRENT_USER } from './action/types';


const jwtToken = localStorage.jwtToken;

if(jwtToken) {
  setJwtToken(jwtToken);
  const decoded_jwt = jwt_decode(jwtToken);
  store.dispatch({
    type: SET_CURRENT_USER,
    payload: decoded_jwt
  });

  const currentTime = Date.now() / 1000;
  
  if(decoded_jwt.exp < currentTime) {
    // handle logout
    store.dispatch(logout());
    window.location.href = "/";
    // window.location.href = "/";
  }

}

function App() {
  return (
    <Provider store={store}>
    <Router>
      <div className="App">
        <Header />
        <Route exact path="/" component={Landingpage} />
        <Route exact path="/register" component={Register} />
        <Route exact path="/login" component={Login} />

        {
          // Private route
        }
        <Switch>
        <SecuredRoute exact path="/dashboard" component={Dashboard} />
        </Switch>

      </div>
    </Router>
    </Provider>
  );
}

export default App;
