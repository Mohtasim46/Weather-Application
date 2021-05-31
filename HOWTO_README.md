# Thinkific-Test
This repository holds the solution of the take home test for thinkific's software engineer role.

The get weather rest api endpoint is protected by JWT authectication of spring security.

You may want to register yourself first.

POST to http://thinkifictestweather-env.eba-un42ghmt.us-east-2.elasticbeanstalk.com/api/customers/register

request body should be - 

```
{
    "username": "mohtasim1@bellah.com",
    "fullName": "Mohtasim Bellah 01",
    "password": "password",
    "confirmPassword": "password"
}
```

After a succesful post, you can login by 

POST to http://thinkifictestweather-env.eba-un42ghmt.us-east-2.elasticbeanstalk.com/api/customers/login

```
{
    "password": "password",
    "username": "mohtasim1@bellah.com"
}
```
You will get a response like - 
```
{
    "success": true,
    "token": "Bearer eyJhbGciOiJIUzUxMiJ9.eyJmdWxsTmFtZSI6Ik1vaHRhc2ltIEJlbGxhaCAwMSIsImlkIjoiMyIsImV4cCI6MTYyMzA1MjcwMCwiaWF0IjoxNjIyNDQ3OTAwLCJ1c2VybmFtZSI6Im1vaHRhc2ltMUBiZWxsYWguY29tIn0.invppF9AX69yGPvUNdq4nkfdI6LKZKiPPYXYwWG_MYD33XqEGdn9r_aoeUVLDhdE4d4_37Ug4BLnOGma9z3jKA"
}
```

Use the token field as the authorization jwt in the header of your GET api request to get the weather data like below.

`Authorization` : `Bearer ${token}`

Example 

`Authorization` : `Bearer eyJhbGciOiJIUzUxMiJ9.eyJmdWxsTmFtZSI6Ik1vaHRhc2ltIEJlbGxhaCAwMSIsImlkIjoiMyIsImV4cCI6MTYyMzA1MjcwMCwiaWF0IjoxNjIyNDQ3OTAwLCJ1c2VybmFtZSI6Im1vaHRhc2ltMUBiZWxsYWguY29tIn0.invppF9AX69yGPvUNdq4nkfdI6LKZKiPPYXYwWG_MYD33XqEGdn9r_aoeUVLDhdE4d4_37Ug4BLnOGma9z3jKA`

## Get current weather of a city now

GET http://thinkifictestweather-env.eba-un42ghmt.us-east-2.elasticbeanstalk.com/api/weather/dhaka

```
{
    "id": 2,
    "cityName": "Dhaka",
    "cityIdentifier": 1185241,
    "timezone": 21600,
    "countryCode": "BD",
    "sunrise": 1622416292,
    "sunset": 1622464853,
    "dt": 1622448083,
    "windSpeed": 3.97,
    "windDeg": 201.0,
    "windGust": 5.99,
    "visibility": 3500,
    "humidity": 78,
    "pressure": 1002,
    "currentTemperatureFeelsLike": 31.77,
    "temperature": 27.99,
    "weatherMain": "Rain",
    "weatherDescription": "moderate rain",
    "weatherIcon": "10d"
}
```

You can use postman to test the above described apis.


