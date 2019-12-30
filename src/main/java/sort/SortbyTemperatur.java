/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sort;

import OpenWeather.WeatherClient;
import data.OpenWeatherResponse;
import java.util.Comparator;

/**
 * Sortieren nach Temperatur
 * @author lukas
 */
public class SortbyTemperatur implements Comparator<String>{

    WeatherClient wc = new WeatherClient(); 
    @Override
    public int compare(String o1, String o2) {
        OpenWeatherResponse opr = wc.getWeather(o1);
        OpenWeatherResponse opr2 = wc.getWeather(o2); 
        if(opr.getMain().getTemp()>opr2.getMain().getTemp())
        {
            return 1;
        }else if (opr.getMain().getTemp()<opr2.getMain().getTemp())
        {
            return -1;
        }else{
        return 0;
        } 
    }  
}
