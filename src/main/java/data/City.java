/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

/**
 *Datenklasse City
 * @author lukas
 * 
 */
public class City {
    private long cityid;
    private String name;
    private Coord coord;
    private String country;
    private String timezone;

    public long getCityid() {
        return cityid;
    }

    public String getName() {
        return name;
    }

    public Coord getCoord() {
        return coord;
    }

    public String getCountry() {
        return country;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setCityid(long cityid) {
        this.cityid = cityid;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCoord(Coord coord) {
        this.coord = coord;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    @Override
    public String toString() {
        return "City{" + "cityid=" + cityid + ", name=" + name + ", coord=" + coord + ", country=" + country + ", timezone=" + timezone + '}';
    }
    
}
