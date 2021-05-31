import React, { Component } from 'react'
import { Link } from 'react-router-dom'
import { connect } from 'react-redux'
import PropTypes from 'prop-types'

class Landingpage extends Component {

    componentDidMount() {
        if(this.props.security.validToken) {
            this.props.history.push("/dashboard");
        }
    }

    render() {
        return (

            <div className="landingpage">
                <div className="light-overlay landing-inner text-dark">
                    <div className="container">
                        <div className="row">
                            <div className="col-ms-12 text-center">
                                <h1 className="display-3 me-md-3" style={{marginTop: '50px'}}>Thinkific Take Home Test</h1>
                                <p className="lead" style={{marginTop: '50px'}}>
                                    Create your account to enjoy current weather information of any city in planet earth !!
                                </p>
                                <hr />
                                <Link className="btn btn-lg btn-primary mr-2" to="/register">
                                    Sign Up
                                </Link>
                                <Link className="btn btn-lg btn-secondary ms-2" to="/login">
                                    Login
                                </Link>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

        )
    }
}

Landingpage.propTypes = {
    security: PropTypes.object.isRequired
}

const mapStateToProps = state => ({
    security: state.security
})

export default connect(mapStateToProps)(Landingpage);