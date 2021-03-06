import React, { Component } from 'react'
import { connect } from 'react-redux';
import PropTypes from 'prop-types'
import classnames from 'classnames'
import { customerLogin } from '../action/securityactions'

class Login extends Component {

    constructor() {
        super();
        this.state = {
            username: "",
            password: "",
            errors: {}
        }

        this.onChange = this.onChange.bind(this);
        this.onSubmit = this.onSubmit.bind(this);
    }

    componentWillReceiveProps(nextProps) {
        if(nextProps.security.validToken) {
            this.props.history.push("/dashboard");
        }

        if(nextProps.errors) {
            this.setState({
                errors: nextProps.errors
            })
        }
    }

    componentDidMount() {
        if(this.props.security.validToken) {
            this.props.history.push("/dashboard");
        }
    }

    onChange(e) {
        this.setState({ [e.target.name]: e.target.value });
    }

    onSubmit(e) {
        e.preventDefault();
        const LoginRequest = {
            username: this.state.username,
            password: this.state.password
        };
        this.props.customerLogin(LoginRequest);
    }

    render() {
        const {errors} = this.state;
        return (
            <div className="login">
            <div className="container">
                <div className="row">
                    <div className="col-md-8 m-auto">
                        <h1 className="display-4 text-center">Log In</h1>
                        <form onSubmit={this.onSubmit}>
                            <div className="mb-3">
                                <input type="email" 
                                className={classnames("form-control form-control-lg", {
                                    "is-invalid": errors.username
                                })}
                                placeholder="Email Address (Username)" 
                                name="username"
                                value={this.state.username}
                                onChange={this.onChange} />
                                {
                                errors.username && (
                                    <div className="invalid-feedback">{errors.username}</div>
                                )
                            }
                            </div>
                            

                            <div className="mb-3">
                                <input type="password" 
                                className={classnames("form-control form-control-lg", {
                                    "is-invalid": errors.password
                                })}
                                placeholder="Password" 
                                name="password"
                                value={this.state.password}
                                onChange={this.onChange} />
                                {
                                errors.password && (
                                    <div className="invalid-feedback">{errors.password}</div>
                                )
                            }
                            </div>
                            
                            <input type="submit" className="btn btn-info btn-block mt-4" />
                        </form>
                    </div>
                </div>
            </div>
        </div>
        )
    }
}

Login.propTypes = {
    customerLogin: PropTypes.func.isRequired,
    security: PropTypes.object.isRequired,
    errors: PropTypes.object.isRequired
}

const mapStateToProps = state => ({
    errors: state.errors,
    security: state.security
})

export default connect(mapStateToProps, {customerLogin})(Login);