import React, { Component } from 'react'
import { connect } from 'react-redux';
import { Link } from 'react-router-dom'
import PropTypes from 'prop-types';
import { logout } from '../action/securityactions';

class Header extends Component {

    logout() {
        this.props.logout();
        window.location.href = "/";
    }

    render() {
        
        const {validToken, user} = this.props.security;

        const customerIsAuthenticated = (
            <div className="collapse navbar-collapse" id="mobile-nav">
                        <ul className="navbar-nav mr-auto">
                            <li className="nav-item">
                                <Link className="nav-link" to="/dashboard">
                                    Dashboard
                                </Link>
                            </li>
                        </ul>

                        <ul className="navbar-nav ms-auto">
                            <li className="nav-item">
                                <Link className="nav-link" to="/dashboard">
                                    {user.fullName}
                                </Link>
                            </li>
                            <li className="nav-item">
                                <Link className="nav-link" to="/logout" onClick={this.logout.bind(this)}>
                                    Logout
                                </Link>
                            </li>
                        </ul>
                    </div>
        );

        const customerIsNotAuthenticated = (
            <div className="collapse navbar-collapse" id="mobile-nav">
                        
                        <ul className="navbar-nav ms-auto">
                            <li className="nav-item">
                                <Link className="nav-link" to="/register">
                                    Sign Up
                                </Link>
                            </li>
                            <li className="nav-item">
                                <Link className="nav-link" to="/login">
                                    Login
                                </Link>
                            </li>
                        </ul>
                    </div>
        );

        let headerLinks;

        headerLinks = (validToken && user)? customerIsAuthenticated: customerIsNotAuthenticated;
        return (
 
            <nav className="navbar navbar-expand-sm bg-dark navbar-dark">
                <div className="container">
                    <Link className="navbar-brand" to="/">
                        Thinkific-Current Weather
                    </Link>

                    {headerLinks}
                    
                </div>

                
            </nav>
        )
    }
}

Header.propTypes = {
    logout: PropTypes.func.isRequired,
    security: PropTypes.object.isRequired
}

const mapStateToProps = state => ({
    security: state.security
});

export default connect(mapStateToProps, {logout})(Header);
