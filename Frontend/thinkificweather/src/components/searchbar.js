import React, { Component } from 'react'
import { connect } from 'react-redux'
import PropTypes from 'prop-types'
import {getCurrentWeather} from '../action/weatheraction'

class Searchbar extends Component {
    constructor() {
        super();

        this.state = {
            cityName: '',
            errors: {}
        }
        this.onChange = this.onChange.bind(this);
        this.onSubmit = this.onSubmit.bind(this);
    }

    onChange(e) {
        this.setState({ [e.target.name]: e.target.value});
    }

    onSubmit(e) {
        e.preventDefault();
        
        console.log('City search - ' + this.state.cityName);
        console.log('CityName Length - ' + this.state.cityName.length);

        if(this.state.cityName == null || this.state.cityName.length === 0) {
            
        }

        this.props.getCurrentWeather(this.state.cityName);
    }
    
    render() {
        return (
            
            <nav className="navbar navbar-expand-lg navbar-light bg-light" style={{ marginTop: `20px` }}>
                <div className="container">
                    <div className="collapse navbar-collapse" id="navbarSupportedContent">
                        <form className="d-flex">
                            <input 
                                className="form-control me-2" 
                                style={{width: '500px'}} 
                                type="search" 
                                placeholder="Search Weather by City" 
                                aria-label="Search"
                                name='cityName'
                                value={this.state.cityName}
                                onChange={this.onChange} />
                            <button className="btn btn-outline-success" 
                                type="submit"
                                onClick={this.onSubmit}>Search</button>
                        </form>
                    </div>
                </div>
            </nav>
        )
    }
}

Searchbar.propTypes = {
    getCurrentWeather: PropTypes.func.isRequired,
    errors: PropTypes.object.isRequired
};

const mapStateToProps = state => ({
    errors: state.errors
})

export default connect(mapStateToProps, {getCurrentWeather})(Searchbar);