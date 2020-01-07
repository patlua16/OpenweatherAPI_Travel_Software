/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import OpenWeather.OpenWeatherIcons_Client;
import java.io.IOException;
import javax.swing.ImageIcon;
import static org.junit.Assert.assertEquals;
import org.junit.FixMethodOrder;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.runners.MethodSorters;

/**
 *
 * @author lukas
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestIcons {
    
    public TestIcons() {
    } 
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }
 
    @org.junit.Test
    public void test2CreateJSON() throws IOException {
        System.out.println("testCreateJSON");
        //Given
        String expResult
                = "javax.swing.ImageIcon@612fc6eb"; 
        //WHEN
        OpenWeatherIcons_Client oc = new OpenWeatherIcons_Client();
        ImageIcon result = oc.getIcon("01d");
        String res = result.toString();
        System.out.println(res);
        //THEN
        assertEquals(expResult, res);
    }
    
}
