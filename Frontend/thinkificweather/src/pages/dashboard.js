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
            isEmpty: true,
        }
    }

    componentWillReceiveProps(nextProps) {
        if(nextProps.errors) {
            this.setState({ error: nextProps.errors.error_message?true:false });
            this.setState({ isEmpty: false });
        }

        if(nextProps.weather) {
            this.setState({ isEmpty: false});
        }
    }

    render() {

        const {weather} = this.props.weather;
        const {errors} = this.props;
        return (
            <div>
                <Searchbar />
                {this.state.error && errors && 
                    (<div className="container">
                        <NotFoundWrapper>
                            <NotfoundIcon>
                                <FontAwesomeIcon icon={faFrown} />
                            </NotfoundIcon>
                            <NotFoundText>{errors.error_message}</NotFoundText>
                        </NotFoundWrapper>
                    </div>)
                }
                {!this.state.error && !this.state.isEmpty && weather && <Weatherdescription weather={weather} />}
                {this.state.isEmpty && !this.state.error && (
                    <div className="container">
                        <NotFoundWrapper>
                            <NotfoundIcon>
                                <FontAwesomeIcon icon={faGrinAlt} />
                            </NotfoundIcon>
                            <NotFoundText>Please enter a city name fron earth to get the current weather !</NotFoundText>
                        </NotFoundWrapper>
                    </div>
                )}
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