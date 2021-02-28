package com.weatherapi.weatherapputility;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class ForecastWeather extends Forecaster{

    /*
    As a weather enthusiast I would like to know,
    how many days it is predicted to be SUNNY (CLEAR),
    in the next 5 DAYS, (from the current days date), or whichever period the free subscription will allow.
    */
    public int findNumberOfDays(WeatherData weatherData) throws ParseException {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date todayDate = new Date();
        System.out.println("Today's Date: "+simpleDateFormat.format(todayDate));

        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_MONTH, forDays);
        String endDate = simpleDateFormat.format(cal.getTime());

        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("HH:mm:ss");

        LinkedHashMap<String,String> map = new LinkedHashMap<>();

        System.out.println("---------------------------------------------------------------------------");
        System.out.println("Following days after today have been predicted of having sunny days:- ");
        System.out.println("-------------------------------------------------------------------------\n");
        for (DataInfo dataInfo : weatherData.getDataInfo()) {
            List<WeatherInfo> weatherInfo = dataInfo.getWeatherInfo();
            String currentDate = simpleDateFormat.format(simpleDateFormat.parse(dataInfo.getDateTime()));

            // To make sure temperature report don't exceed given number of days
            if(currentDate.equals(endDate)) break;

            // Put the first occurrence of sunny weather for each given day, only near option in API representing sunny day was type- clear sky and icon- 01d
            if(simpleDateFormat.parse(currentDate).compareTo(todayDate)>0 && !map.containsKey(currentDate) && weatherInfo.get(0).getwType().equalsIgnoreCase("Clear") && weatherInfo.get(0).getwIcon().equalsIgnoreCase("01d")) {
                map.put(currentDate, "sunny with " + weatherInfo.get(0).getwDesc() + " after " + simpleDateFormat2.format(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(dataInfo.getDateTime()))+" on this day");
            }
        }

        Iterator it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            System.out.println(pair.getKey() + " => Weather will be " + pair.getValue());

        }

        System.out.println("\nTotal days having sunny weather:- "+map.size()+"\n");
        return map.size();
    }

}
