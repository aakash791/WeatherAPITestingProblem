# WeatherAPITestingProblem

Navigate to directory:- WeatherAPITestingProblem/out/artifacts/WeatherAppUtility_jar/

Type command to run Weather Application:- java -jar WeatherAppUtility.jar

Possible Output:-

Today's Date: 2021-03-01
 Day: 2021-03-04
Forecasted temperature at 06:00:00:= 20.37 degree Celsius
Maximum Temperature: 20.37 degree Celsius
Minimum Temperature: 20.37 degree Celsius
Feels Like Temperature: 18.21 degree Celsius

------------------------------------------------------------

 Day: 2021-03-05
Forecasted temperature at 06:00:00:= 20.26 degree Celsius
Maximum Temperature: 20.26 degree Celsius
Minimum Temperature: 20.26 degree Celsius
Feels Like Temperature: 16.2 degree Celsius

------------------------------------------------------------

Total days where temperature was more than 20.0 degree Celsius:- 2

Today's Date: 2021-03-01
---------------------------------------------------------------------------
Following days after today have been predicted of having sunny days:- 
-------------------------------------------------------------------------

2021-03-04 => Weather will be sunny with clear sky after 21:00:00 on this day

Total days having sunny weather:- 1

# Assumptions & Requirements:

City -> Sydney
Temperature -> Celsius 

# API call for getting Sydney temperature forecast for upto next 5 days in celsius

api.openweathermap.org/data/2.5/forecast?q=Sydney&units=metric&appId=e31102d1d1f4f9efd529b87dc296bda8

# User story - 1

As a weather enthusiast I would like to know,
    NUMBER of DAYS in SYDNEY where the TEMPERATURE is predicted to be above 20 DEGREES
    in the next 5 DAYS, (from the current days date), or whichever period the free subscription will allow.

# User story - 2

As a weather enthusiast I would like to know,
    how many days it is predicted to be SUNNY (CLEAR),
    in the next 5 DAYS, (from the current days date), or whichever period the free subscription will allow.


