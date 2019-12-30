/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OpenWeather;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.LinkedList;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author lukas
 * In dieser Klasse bekommt man die notwendigen Icons */
public class OpenWeatherIcons_Client {
     
    private LinkedList<ImageIcon> icons;
    BufferedImage image = null;
    
    /**
     * Das ist der Konstruktor für die Klasse und es wird eine LinkedList initialisiert
     */
    public OpenWeatherIcons_Client() {
        this.icons = new LinkedList<>();
    }
    
    /**
     * @param kuerzel um das richtige Image zu bekommen
     * Durch diese Methode bekommt man notwendige Icon als ImageIcon
     */
    public ImageIcon getIcon(String kuerzel) throws MalformedURLException, IOException
    {
       URL url = new URL("http://openweathermap.org/img/wn/"+kuerzel+"@2x.png");
       image = ImageIO.read(url);
       ImageIcon icon = new ImageIcon(image);
       return icon;
    }
  
    
    
}
