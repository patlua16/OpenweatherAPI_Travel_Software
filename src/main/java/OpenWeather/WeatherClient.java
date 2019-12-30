/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OpenWeather;

import com.google.gson.Gson;
import data.OpenWeatherResponse;
import data.Weather;
import data.Weather_Forecast;
import java.awt.PageAttributes;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import net.aksingh.owmjapis.api.APIException;
import net.aksingh.owmjapis.core.OWM;
import net.aksingh.owmjapis.model.CurrentWeather;
/**
 *
 * @author lukas
* https://github.com/aksinghnet/OWM-JAPIs 
In dieser Klasse bekommt man die Daten vom OpenWeather*/

public class WeatherClient {
    private static final String BASE_URL = "https://api.openweathermap.org/data/2.5/weather";
    private static String APIKEY = "1ae2d2300b56e6cbce5257191a922259";
    private static String BASE_URL_FORECAST = "https://api.openweathermap.org/data/2.5/forecast";
    private static Client client;
    private Gson gson;

    /**
     * Konstruktor der Klasse WeatherClients
     */
    public WeatherClient() {
        gson = new Gson();
    } 
    
    /**
     * Mit dieser Methode bekommt man das aktuelle Wetter eine bestimmten City
     * @param city um das Wetter einer bestimmten Stadt zu finden
     * @return OpenWeatherResponse Objekt
     */
    public OpenWeatherResponse getWeather(String city)
    {
        client = ClientBuilder.newClient();
        String uri = BASE_URL + "?q="+city+"&appid="+APIKEY;
        WebTarget target = client.target(uri);
        Response result = target.request().accept(MediaType.APPLICATION_JSON).get();
        String jsondaten = result.readEntity(String.class);
        OpenWeatherResponse opr = gson.fromJson(jsondaten, OpenWeatherResponse.class);    
        return opr;
    }
    
    /**
     * Mit dieser Methode bekommt man einen 5 Tages Forecast vom OpenWeather zurück
     * @param city um den Forecast einer bestimmten Stadt zu finden
     * @return  Weather_Forecast Objekt
     */
    public Weather_Forecast getForecast(String city)
    {
        client = ClientBuilder.newClient();
        String uri = BASE_URL_FORECAST + "?q="+city+"&appid="+APIKEY;
        WebTarget target = client.target(uri);
        Response result = target.request().accept(MediaType.APPLICATION_JSON).get(); 
        String jsondaten = result.readEntity(String.class); 
        Weather_Forecast opr = gson.fromJson(jsondaten, Weather_Forecast.class); 
        return opr;
    }
    
    public static void main(String[] args) throws APIException {
       WeatherClient cl = new WeatherClient();
       Weather_Forecast opr = cl.getForecast("Zehensdorf");
        System.out.println(opr.getWeather().get(0)); 
        System.out.println(opr.getWeather().get(1));
        System.out.println(opr.getWeather().get(2));
        System.out.println(opr.getWeather().get(3)); 
        
        

    }
    
}
