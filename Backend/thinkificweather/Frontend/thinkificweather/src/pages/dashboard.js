import React, { Component } from 'react'
import { connect } from 'react-redux';
import PropTypes from 'prop-types'
import Searchbar from '../components/searchbar'
import Weatherdescription from '../components/weatherdescription';
import { faFrown, faGrinAlt } from '@fortawesome/free-solid-svg-icons';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import NotfoundIcon from '../components/styles/notfoundicon';
import NotFoundText from '../components/styles/notfoundtext';
import NotFoundWrapper from '../components/styles/notfoundwrapper';

class Dashboard extends Component {
    constructor() {
        super();

        this.state = {
            error: false,
        }
    }

    componentWillReceiveProps(nextProps) {
        if(nextProps.errors) {
            this.setState({ error: nextProps.errors.error_message?true:false });
        }
    }

    dashboardMessage = (message, icon) => (
        <div className="container">
                        <NotFoundWrapper>
                            <NotfoundIcon>
                                <FontAwesomeIcon icon={icon} />
                            </NotfoundIcon>
                            <NotFoundText>{message}</NotFoundText>
                        </NotFoundWrapper>
                    </div>
    );

    render() {

        const {weather} = this.props.weather;
        const {errors} = this.props;

        let dashboardContent;
        
        const errorContent = (this.dashboardMessage(errors.error_message, faFrown));
        
        const neutralContent = (this.dashboardMessage('Please enter a city name fron earth to get the current weather !', faGrinAlt));

        if(errors && errors.error_message != null) {
            dashboardContent = errorContent;
        } else if(weather && weather.cityName != null) {
            dashboardContent = (<Weatherdescription weather={weather} />);
        } else {
            dashboardContent = neutralContent;
        }

        return (
            <div>
                <Searchbar />
                {
                    dashboardContent
                    /* {this.state.error && errors && 
                    (<div className="container">
                        <NotFoundWrapper>
                            <NotfoundIcon>
                                <FontAwesomeIcon icon={faFrown} />
                            </NotfoundIcon>
                            <NotFoundText>{errors.error_message}</NotFoundText>
                        </NotFoundWrapper>
                    </div>)
                }
                {!this.state.error && weather && <Weatherdescription weather={weather} />}
                {(!this.state.error || weather.cityName.length() > 0) && (
                    <div className="container">
                        <NotFoundWrapper>
                            <NotfoundIcon>
                                <FontAwesomeIcon icon={faGrinAlt} />
                            </NotfoundIcon>
                            <NotFoundText>Please enter a city name fron earth to get the current weather !</NotFoundText>
                        </NotFoundWrapper>
                    </div>
                )} */}
            </div>
            
        )
    }
}

Dashboard.propTypes = {
    weather: PropTypes.object.isRequired,
    errors: PropTypes.object.isRequired
}

const mapStateToProps = state => ({
    weather: state.weather,
    errors: state.errors
})
export default connect(mapStateToProps)(Dashboard);