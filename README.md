# Thinkific-Test
This repository holds the solution of the take home test for thinkific's software engineer role.

### Tech Stack
I have used reactjs for the frontend and spring-boot for the backend development with mysql as database.
I have used aws cloud services RDS & Beanstalk to host the full stack application.

First I hosted only the backend service with mysql here: http://thinkifictestweather-env.eba-un42ghmt.us-east-2.elasticbeanstalk.com/
The api endpoint descriptions are given below with expected request body or payload.

Then I hosted the fullstack service here separately: 
```
http://thinkificweather-env.eba-v4bi3twu.ap-south-1.elasticbeanstalk.com/
```

So you may two different links in the api documentation.

### Date
May 31, 2021

### Location of deployed application

If applicable, please provide the url where we can find and interact with your running application.

This is the fullstack spring boot, react application URL hosted in aws. 

The URL: 

```
http://thinkificweather-env.eba-v4bi3twu.ap-south-1.elasticbeanstalk.com/
```

Hit this api endpoint to register yourself and get the current weather of your desired city.

Existing username, password:  ```
{
    "password": "password",
    "username": "mohtasim@bellah.com"
}
```

### Time spent
Around 13 hours in total for 3 days. 4 more extra hours for hosting.

### Assumptions made

1. Well, using the real api from https://openweathermap.org/api, it felt like that I'm building a proxy server. The city weather api required a api key. I assumed that it is okay to use the same api_key for all users who will use my server since it won't affect the user end.
2. To complete the stretch goals to some extent, I tried to build a UI. Since I dont have a gui guide or something, I tried to take ideas from different weather forecasting websites and took some of their stylings. 
3. Since the test was to get only current weather for a city, I didn't take any hourly/daily/weekly/monthly weather forecast predictions. 
4. I assumed it would be okay to simple providing the basic weather data. 
5. I assumed the weather's temparature unit is alright with only degree celcius. Although there were option to take other units but I assumed degree celcius is mostly used and provided only that option.
6. For authentication stretch goal, I only authenticated user and secured my rest endpoint with jwt. I assuemd it is alright to do so.   

### Shortcuts/Compromises made
If applicable. Did you do something that you feel could have been done better in a real-world application? Please let us know.

1. In the backend spring-boot app, each user searches for city weather could be personalized i.e. user1 search for vancouver, toronto; user2 searched for dhaka, delhi; so in the frontend dashboard for each user, their personalized previous search could be shown as a list.
2. In the authentication, oAuth could be added for authentication.
3. In the real-world application, there could have been other parameters to search for a city weather such as lattitude, longitude or picking up city from the world map maybe.
4. In real-world, each different user should have different api_key for hitting openweather endpoint.
5. I haven’t handled in case of ‘no-internet’ or incase if the ‘AWS RDS’ instance is terminated.
6. I haven't handled the frontend views for mobile devices as well.


### Stretch goals attempted
If applicable, use this area to tell us what stretch goals you attempted. What went well? What do you wish you could have done better? If you didn't attempt any of the stretch goals, feel free to let us know why.

1. I have attempted for all the stretch goals. 
2. I have built a good UI for the service
3. I have added authentication to the service
4. I have deployed my API and the api paths are given above in this document.
5. I have used a real weather API via your service to fetch the actual weather. I have used https://openweathermap.org/ as my data source as suggested.

I was having a bit of difficulty hosting or deploying my react app separately in aws as I haven't done it before.

But I managed to do it anyway.

The development goals went well but I struggled in deployment. I successfully deployed the backend service connected to a cloud mysql (AWS RDS) but struggled to deploy the frontend.

### Instructions to run assignment locally

Please find the instructions to test the backend API in the HOWTO_README.md 
But to run the application locally,
To test the backend api,
1. Download and install postman in your machine. 
2. Then follow the above instruction. For ease of viewing, I am providing the instructions below again - 

This is the backend spring boot application URL hosted in aws. I am providing the api and expected request body example here.
POST to http://thinkificweather-env.eba-v4bi3twu.ap-south-1.elasticbeanstalk.com/api/customers/register
```
{
    "username": "mohtasim@bellah.com",
    "fullName": "Mohtasim Bellah",
    "password": "password",
    "confirmPassword": "password"
}
```
POST to http://thinkificweather-env.eba-v4bi3twu.ap-south-1.elasticbeanstalk.com/api/customers/login
** make sure to add content-type: application/json in the header.
```
{
    "password": "password",
    "username": "mohtasim@bellah.com"
}
```
The response body will contain the Authorization token named as 'token' in the json response.
POST to http://Thinkifictestweather-env.eba-un42ghmt.us-east-2.elasticbeanstalk.com/api/weather/{cityName}
Hit this api endpoint to get the current weather of your desired city.
** Make sure to use the token received upon login in your header as 'Authorization: {token}'

3. If you want to run the spring-boot application, 
  ** You have to have JDK in you system. Also Java 8. 
  ** I recommend having intellij ide to open the spring-boot application.
  ** then just hit the geen run button. If you havent done it before, you might have to add a configuration and install a spring-boot plugin through the IDE.
  
4. If you want to run the reactjs application,
  ** Install Node & npm.
  ** In the project directory run the 'npm start' command. 
 
### What did you not include in your solution that you want us to know about?
Were you short on time and not able to include something that you want us to know about? Please list it here so that we know that you considered it.

Yes. I haven't been able to deploy the reactjs app in the aws. Well, I have deployed but it seemed not to be able to fetch data from the server. I guess I have use same ec2 instance through beanstalk or reconfigure the security of the instance. I just need a bit of time. I really didn't see this coming.

### Other information about your submission that you feel it's important that we know if applicable.

Well, I just didn't use https://openweathermap.org/ API to get the current weather and converted the response from https://openweathermap.org/ to my own custom response. 

https://openweathermap.org/ provides same response for a city within 10 minutes. They only update the values every 10 minute. So what I did was, I cached the response and request time of the user for a city in the database. So if a user requests couple of times within 10 minutes, I avoided to hit the https://openweathermap.org/ api and provided the previous response I saved in the database.

The reason to avoid multiple hit in the https://openweathermap.org/ endpoint is just to speed up my restapi's response time. 

Here is my custom json response for hitting http://thinkificweather-env.eba-v4bi3twu.ap-south-1.elasticbeanstalk.com/api/weather/seattle 

```
{
    "id": 4,
    "cityName": "Seattle",
    "cityIdentifier": 5809844,
    "timezone": -25200,
    "countryCode": "US",
    "sunrise": 1622377016,
    "sunset": 1622433436,
    "dt": 1622395312,
    "windSpeed": 2.68,
    "windDeg": 299.0,
    "windGust": 4.92,
    "visibility": 10000,
    "humidity": 59,
    "pressure": 1021,
    "currentTemperatureFeelsLike": 17.7,
    "temperature": 18.28,
    "weatherMain": "Clear",
    "weatherDescription": "clear sky",
    "weatherIcon": "01d"
}
```
