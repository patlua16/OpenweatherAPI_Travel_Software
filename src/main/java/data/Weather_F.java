/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.util.ArrayList;

/**
 *Datenklasse Weather_F
 * @author lukas
 */
public class Weather_F {
     private long dt;
    private Main main;
    private ArrayList<Weather> weather;
    private Clouds clouds;
    private Wind wind;
    private Sys sys;
    private String dt_txt;

    public long getDt() {
        return dt;
    }

    public Main getMain() {
        return main;
    }

    public ArrayList<Weather> getWeather() {
        return weather;
    }

    public Clouds getClouds() {
        return clouds;
    }

    public Wind getWind() {
        return wind;
    }

    public Sys getSys() {
        return sys;
    }

    public String getDt_text() {
        return dt_txt;
    }

    public void setDt(long dt) {
        this.dt = dt;
    }

    public void setMain(Main main) {
        this.main = main;
    }

    public void setWeather(ArrayList<Weather> weather) {
        this.weather = weather;
    }
 
    public void setClouds(Clouds clouds) {
        this.clouds = clouds;
    }

    public void setWind(Wind wind) {
        this.wind = wind;
    }

    public void setSys(Sys sys) {
        this.sys = sys;
    }

    public void setDt_text(String dt_text) {
        this.dt_txt = dt_text;
    }

    @Override
    public String toString() {
        return "WeatherForecast{" + "dt=" + dt + ", main=" + main + ", weather=" + weather + ", clouds=" + clouds + ", wind=" + wind + ", sys=" + sys + ", dt_txt=" + dt_txt + '}';
    }
}
