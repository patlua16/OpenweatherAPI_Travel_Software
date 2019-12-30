/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *Datenklasse Weather_Forecast
 * @author lukas
 */
public class Weather_Forecast {
    private String code;
    private int message;
    private City city;
    private int cnt;
    private ArrayList<Weather_F> list;

    public String getCode() {
        return code;
    }

    public int getMessage() {
        return message;
    }

    public City getCity() {
        return city;
    }

    public int getCnt() {
        return cnt;
    }

    public ArrayList<Weather_F> getWeather() {
        return list;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setMessage(int message) {
        this.message = message;
    }

    public void setCity(City city) {
        this.city = city;
    }
    
    public String getDateString(long dtt)
    {
        Date date = new Date(dtt*1000L);
        SimpleDateFormat jdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
        String date2 = jdf.format(date);
        return date2;
    }
    
    public String getUhrzeitString(long dtt)
    {
        Date date = new Date(dtt*1000L);
        SimpleDateFormat jdf = new SimpleDateFormat("HH:mm"); 
        String date2 = jdf.format(date);
        return date2;
    }

    public void setCnt(int cnt) {
        this.cnt = cnt;
    }

    public void setWeather(ArrayList<Weather_F> weather) {
        this.list = weather;
    }
    
    
    
    
    

    @Override
    public String toString() {
        return "Weather_Forecast{" + "code=" + code + ", message=" + message + ", city=" + city + ", cnt=" + cnt + ", list=" + list + '}';
    }
    
    
}
