
import Header from './components/header';
import {BrowserRouter as Router} from 'react-router-dom';
import "bootstrap/dist/css/bootstrap.min.css";
import Dashboard from './pages/dashboard';
import { Provider } from 'react-redux';
import store from './store';

function App() {
  return (
    <Provider store={store}>
    <Router>
      <div className="App">
        <Header />
        <Dashboard />
      </div>
    </Router>
    </Provider>
  );
}

export default App;
