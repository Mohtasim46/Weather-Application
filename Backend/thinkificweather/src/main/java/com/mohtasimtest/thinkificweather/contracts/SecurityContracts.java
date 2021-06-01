package com.mohtasimtest.thinkificweather.contracts;

public class SecurityContracts {

    public static final String SING_UP_URL = "/api/customers/**";
    public static final String H2_URL = "h2-console/**";

    public static final String SECRET_KEY = "SecretKeyToGenerateJWTs";
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";
    public static final long EXPIRATION_TIME = 604800_000; // Auth token will be valid for 7 days

}
