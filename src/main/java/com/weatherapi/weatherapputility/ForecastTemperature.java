package com.weatherapi.weatherapputility;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class ForecastTemperature extends Forecaster{

    /*
    As a weather enthusiast I would like to know,
    NUMBER of DAYS in SYDNEY where the TEMPERATURE is predicted to be above 20 DEGREES
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

        for (DataInfo dataInfo : weatherData.getDataInfo()) {
            String currentDate = simpleDateFormat.format(simpleDateFormat.parse(dataInfo.getDateTime()));

            // To make sure temperature report don't exceed given number of days
            if(currentDate.equals(endDate)) break;

            // Put the first occurrence of day that have temperature above than the given limit
            if(simpleDateFormat.parse(currentDate).compareTo(todayDate)>0 && !map.containsValue(currentDate) && dataInfo.getTempInfo().getTempDay() > tempLimit)
                map.put(currentDate, "Forecasted temperature at "+ simpleDateFormat2.format(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(dataInfo.getDateTime()))+":= "+ dataInfo.getTempInfo().getTempMax()+ " degree Celsius\n"
            +"Maximum Temperature: " + dataInfo.getTempInfo().getTempMax()+ " degree Celsius\n"
            +"Minimum Temperature: " + dataInfo.getTempInfo().getTempMin() + " degree Celsius\n"
            +"Feels Like Temperature: " + dataInfo.getTempInfo().getFeelsLike() + " degree Celsius\n");
        }


        Iterator it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            System.out.println(" Day: " + pair.getKey());
            System.out.println(pair.getValue());
            System.out.println("------------------------------------------------------------\n");
        }

        System.out.println("Total days where temperature was more than "+ tempLimit +" degree Celsius:- "+map.size()+"\n");
        return map.size();
    }
}
