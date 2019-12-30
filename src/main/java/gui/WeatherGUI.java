/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import OpenWeather.OpenWeatherIcons_Client;
import OpenWeather.WeatherClient;
import bl.DestinationListModel;
import data.OpenWeatherResponse;
import data.Weather_F;
import data.Weather_Forecast;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import org.jdom2.JDOMException;

/**
 * Haupt-GUI 
 * @author lukas
 */
public class WeatherGUI extends javax.swing.JFrame {

    private DestinationListModel listmodel;
    private WeatherClient wc;
    private Weather_Forecast fc = null;
    private ArrayList<Weather_F> forecast_today, forecast_day1, forecast_day2, forecast_day3, forecast_day4, forecast_day5;
    private LinkedList<ImageIcon> icons;
    private OpenWeatherIcons_Client owc;
    /**
     * Creates new form WeatherGUI
     */
    private Destination_Eingabe desti_dialog = new Destination_Eingabe(this, false);

    /**
     * GUI Konstruktor
     */
    public WeatherGUI() {
        try {
            initComponents();
            listmodel = new DestinationListModel();
            liste.setModel(listmodel);

            listmodel.loadXML();

            wc = new WeatherClient();
            owc = new OpenWeatherIcons_Client();
            setButtonDay();
            tfdate.setSize(200, 200);
        } catch (JDOMException ex) {
            ex.getMessage();
        } catch (IOException ex) {
          ex.getMessage();
        }
    }

    /**
     * Hier werden Forecast-String auf 6 Listen aufgeteilt
     * @throws ParseException 
     */
    public void filterForecast() throws ParseException {
        forecast_today = new ArrayList<>();
        forecast_day1 = new ArrayList<>();
        forecast_day2 = new ArrayList<>();
        forecast_day3 = new ArrayList<>();
        forecast_day4 = new ArrayList<>();
        forecast_day5 = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("EEEE");
        ArrayList<Weather_F> weaf = fc.getWeather();
        for (int i = 0; i < weaf.size(); i++) {
            Date date = new Date(weaf.get(i).getDt() * 1000L);
            String date2 = sdf.format(date);
            String dayOfWeek = sdf.format(new Date()); 
            if (dayOfWeek.equals(date2)) {
                System.out.println("");
                System.out.println(weaf.get(i).toString());
                forecast_today.add(weaf.get(i));
            } else if (date2.equals(btDay1.getText())) {
                forecast_day1.add(weaf.get(i));
            } else if (date2.equals(btDay2.getText())) {
                forecast_day2.add(weaf.get(i));
            } else if (date2.equals(btDay3.getText())) {
                forecast_day3.add(weaf.get(i));
            } else if (date2.equals(btDay4.getText())) {
                forecast_day4.add(weaf.get(i));
            } else if (date2.equals(btDay5.getText())) {
                forecast_day5.add(weaf.get(i));
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        liste = new javax.swing.JList<>();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        tfdate = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        tftemperatur = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        tftempmin = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        tftempmax = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        tfpressure = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        tfhumidity = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        btToday = new javax.swing.JButton();
        btDay1 = new javax.swing.JButton();
        btDay2 = new javax.swing.JButton();
        btDay3 = new javax.swing.JButton();
        btDay4 = new javax.swing.JButton();
        btDay5 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        uhrzeit1 = new javax.swing.JLabel();
        uhrzeit2 = new javax.swing.JLabel();
        uhrzeit3 = new javax.swing.JLabel();
        uhrzeit4 = new javax.swing.JLabel();
        uhrzeit5 = new javax.swing.JLabel();
        uhrzeit6 = new javax.swing.JLabel();
        uhrzeit7 = new javax.swing.JLabel();
        uhrzeit8 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        labelvor1 = new javax.swing.JLabel();
        labelvor2 = new javax.swing.JLabel();
        labelvor3 = new javax.swing.JLabel();
        labelvor4 = new javax.swing.JLabel();
        labelvor5 = new javax.swing.JLabel();
        labelvor6 = new javax.swing.JLabel();
        labelvor7 = new javax.swing.JLabel();
        labelvor8 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        description1 = new javax.swing.JLabel();
        description2 = new javax.swing.JLabel();
        description3 = new javax.swing.JLabel();
        description4 = new javax.swing.JLabel();
        description5 = new javax.swing.JLabel();
        description6 = new javax.swing.JLabel();
        description7 = new javax.swing.JLabel();
        description8 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        hinzufuegen = new javax.swing.JMenuItem();
        loeschen = new javax.swing.JMenuItem();
        sort = new javax.swing.JMenu();
        Temperture = new javax.swing.JMenuItem();
        Pressure = new javax.swing.JMenuItem();
        Hummidity = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("OpenWeather_App");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        liste.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listeMouseClicked(evt);
            }
        });
        liste.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listeValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(liste);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Current Weather ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        jPanel1.setLayout(new java.awt.GridLayout(6, 2));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Date");
        jPanel1.add(jLabel1);

        tfdate.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tfdate.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        tfdate.setMinimumSize(new java.awt.Dimension(28, 15));
        tfdate.setName(""); // NOI18N
        tfdate.setPreferredSize(new java.awt.Dimension(28, 15));
        jPanel1.add(tfdate);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Temperature");
        jPanel1.add(jLabel2);

        tftemperatur.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jPanel1.add(tftemperatur);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Temperature (min)");
        jPanel1.add(jLabel3);

        tftempmin.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jPanel1.add(tftempmin);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Temperature (max)");
        jPanel1.add(jLabel4);

        tftempmax.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jPanel1.add(tftempmax);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Pressure");
        jPanel1.add(jLabel5);

        tfpressure.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jPanel1.add(tfpressure);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Humidity");
        jPanel1.add(jLabel6);

        tfhumidity.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jPanel1.add(tfhumidity);

        jPanel2.setLayout(new java.awt.GridLayout(1, 6));

        btToday.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btTodayActionPerformed(evt);
            }
        });
        jPanel2.add(btToday);

        btDay1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDay1ActionPerformed(evt);
            }
        });
        jPanel2.add(btDay1);

        btDay2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDay2ActionPerformed(evt);
            }
        });
        jPanel2.add(btDay2);

        btDay3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDay3ActionPerformed(evt);
            }
        });
        jPanel2.add(btDay3);

        btDay4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDay4ActionPerformed(evt);
            }
        });
        jPanel2.add(btDay4);

        btDay5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDay5ActionPerformed(evt);
            }
        });
        jPanel2.add(btDay5);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("5 day weather forecast"));

        jPanel4.setLayout(new java.awt.GridLayout(1, 8));

        uhrzeit1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        uhrzeit1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel4.add(uhrzeit1);

        uhrzeit2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        uhrzeit2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel4.add(uhrzeit2);

        uhrzeit3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        uhrzeit3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel4.add(uhrzeit3);

        uhrzeit4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        uhrzeit4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel4.add(uhrzeit4);

        uhrzeit5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        uhrzeit5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel4.add(uhrzeit5);

        uhrzeit6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        uhrzeit6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel4.add(uhrzeit6);

        uhrzeit7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        uhrzeit7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel4.add(uhrzeit7);

        uhrzeit8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        uhrzeit8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel4.add(uhrzeit8);

        jPanel5.setLayout(new java.awt.GridLayout(1, 8));

        labelvor1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel5.add(labelvor1);

        labelvor2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel5.add(labelvor2);

        labelvor3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel5.add(labelvor3);

        labelvor4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel5.add(labelvor4);

        labelvor5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel5.add(labelvor5);

        labelvor6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel5.add(labelvor6);

        labelvor7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel5.add(labelvor7);

        labelvor8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel5.add(labelvor8);

        jPanel6.setLayout(new java.awt.GridLayout(1, 8));

        description1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel6.add(description1);

        description2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel6.add(description2);

        description3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel6.add(description3);

        description4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel6.add(description4);

        description5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel6.add(description5);

        description6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel6.add(description6);

        description7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel6.add(description7);

        description8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel6.add(description8);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(122, Short.MAX_VALUE))
        );

        jMenu2.setText("Destination");

        hinzufuegen.setText("Add ");
        hinzufuegen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hinzufuegenActionPerformed(evt);
            }
        });
        jMenu2.add(hinzufuegen);

        loeschen.setText("Delete");
        loeschen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loeschenActionPerformed(evt);
            }
        });
        jMenu2.add(loeschen);

        sort.setText("Sort by");

        Temperture.setText("Sort by Temperture");
        Temperture.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TempertureActionPerformed(evt);
            }
        });
        sort.add(Temperture);

        Pressure.setText("Sort by Pressure");
        Pressure.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PressureActionPerformed(evt);
            }
        });
        sort.add(Pressure);

        Hummidity.setText("Sort by Hummidity");
        Hummidity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HummidityActionPerformed(evt);
            }
        });
        sort.add(Hummidity);

        jMenu2.add(sort);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 546, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jScrollPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Mit dieser Methode wird eine Destination zur Liste hinzugefügt
     * @param evt 
     */
    private void hinzufuegenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hinzufuegenActionPerformed
        try {
            desti_dialog = new Destination_Eingabe(this, true);
            if (desti_dialog.isIsOkay()) {
                desti_dialog.setVisible(true);
                String destination = desti_dialog.getDestination();
                listmodel.add(destination);
            }
        } catch (Exception e) {
            e.getMessage();
        }
    }//GEN-LAST:event_hinzufuegenActionPerformed

    /**
     * Hier wird eine Destination aus der Liste entfernt
     * @param evt 
     */
    private void loeschenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loeschenActionPerformed
        try {
            int index = liste.getSelectedIndex();
            if (index == -1) {
                JOptionPane.showMessageDialog(null, "Sie haben kein Element ausgewählt");

            } else {
                if (JOptionPane.showConfirmDialog(null, "Möchte Sie das ausgewählte Element wirklich löschen?", "Nachfrage", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                    listmodel.delete(index);
                } else {
                    JOptionPane.showMessageDialog(null, "Das Element wurde nicht aus der Liste gelöscht!");
                }
            }

        } catch (Exception e) {
            e.getMessage();
        }
    }//GEN-LAST:event_loeschenActionPerformed

    /**
     * Beim Schließen der GUI wird hier die Liste in einer XML-Datei gespeichert
     * @param evt 
     */
    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        try {
            listmodel.saveXML(listmodel.getDestination());
        } catch (Exception e) {
            e.getMessage();
        }
    }//GEN-LAST:event_formWindowClosing

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened

    }//GEN-LAST:event_formWindowOpened

    private void listeValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listeValueChanged

    }//GEN-LAST:event_listeValueChanged

    /**
     * Hier wird nach der Auswahl einer Destination das aktuelle Wetter angezeigt
     * @param evt 
     */
    private void listeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listeMouseClicked
        try { 
            changeDaten(); 
        } catch (ParseException ex) {
            Logger.getLogger(WeatherGUI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(WeatherGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_listeMouseClicked

    /**
     * Tagesvorschau Today
     * @param evt 
     */
    private void btTodayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btTodayActionPerformed
        try {
            setdaten(forecast_today);
            setIcons(forecast_today);
        } catch (IOException ex) {
            ex.getMessage();
        }
    }//GEN-LAST:event_btTodayActionPerformed

    /**
     * Tagesvorschau 1
     * @param evt 
     */
   
    private void btDay1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDay1ActionPerformed
        try {
            setdaten(forecast_day1);
            setIcons(forecast_day1);
        } catch (IOException ex) {
           ex.getMessage();
        }
    }//GEN-LAST:event_btDay1ActionPerformed

    /**
     * Tagesvorschau 2
     * @param evt 
     */
    private void btDay2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDay2ActionPerformed
        try {
            setdaten(forecast_day2);
            setIcons(forecast_day2);
        } catch (IOException ex) {
            ex.getMessage();
        }
    }//GEN-LAST:event_btDay2ActionPerformed

    /**
     * Tagesvorschau 3
     * @param evt 
     */
    private void btDay3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDay3ActionPerformed
        try {
            setdaten(forecast_day3);
            setIcons(forecast_day3);
        } catch (IOException ex) {
            ex.getMessage();
        }
    }//GEN-LAST:event_btDay3ActionPerformed

    /**
     * Tagesvorschau 4
     * @param evt 
     */
    private void btDay4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDay4ActionPerformed
        try {
            setdaten(forecast_day4);
            setIcons(forecast_day4);
        } catch (IOException ex) {
            ex.getMessage();
        }
    }//GEN-LAST:event_btDay4ActionPerformed

    /**
     * Tagesvorschau 5
     * @param evt 
     */
    private void btDay5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDay5ActionPerformed
        try {
            setdaten(forecast_day5);
            setIcons(forecast_day5);
        } catch (IOException ex) {
            ex.getMessage();
        }
    }//GEN-LAST:event_btDay5ActionPerformed

    /**
     * Wetter-Vorhersage für die kommenden Tage setzten
     * @param weather
     * @throws IOException 
     */
    public void setdaten(ArrayList<Weather_F> weather) throws IOException {
        try {
            long dt = weather.get(0).getDt();
            String name = fc.getDateString(dt);
            tfdate.setText(name);
            tftemperatur.setText(String.format("%.2f°C", weather.get(0).getMain().getTemp() - 273.15));
            tftempmax.setText(String.format("%.2f°C", weather.get(0).getMain().getTemp_max() - 273.15));
            tftempmin.setText(String.format("%.2f°C", weather.get(0).getMain().getTemp_min() - 273.15));
            tfhumidity.setText(weather.get(0).getMain().getHumidity() + "");
            tfpressure.setText(weather.get(0).getMain().getPressure() + "");
        } catch (Exception e) {
            e.getMessage();
        }
    }

    /**
     * Liste nach Temperatur sortieren
     * @param evt 
     */
    private void TempertureActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TempertureActionPerformed
        try {
            listmodel.sortByTemperature();
        } catch (Exception e) {
            e.getMessage();
        }
        
    }//GEN-LAST:event_TempertureActionPerformed

    /**
     * Liste nach Pressure sortieren
     * @param evt 
     */
    private void PressureActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PressureActionPerformed
        try {
            listmodel.sortByPressure();
        } catch (Exception e) {
            e.getMessage();
        }
    }//GEN-LAST:event_PressureActionPerformed

    /**
     * Liste nach Hummidity sortieren
     * @param evt 
     */
    private void HummidityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HummidityActionPerformed
        try {
            listmodel.sortByHumidity();
        } catch (Exception e) {
            e.getMessage();
        }
    }//GEN-LAST:event_HummidityActionPerformed

    /**
     * Icons für die Wettervorhersage setzen
     * @param liste
     * @throws IOException 
     */
    public void setIcons(ArrayList<Weather_F> liste) throws IOException {
        int help = 1;
        for (int i = 0; i < liste.size(); i++) {
            String name2 = liste.get(i).getWeather().get(0).getIcon();
            ImageIcon icon = owc.getIcon(name2);
            long dr = liste.get(i).getDt();
            String uhrzeit = fc.getUhrzeitString(dr);
            switch (help) {
                case 1:
                    labelvor1.setIcon(icon);
                    description1.setText(liste.get(i).getWeather().get(0).getDescription());
                    uhrzeit1.setText(uhrzeit);
                    break;
                case 2:
                    labelvor2.setIcon(icon);
                    description2.setText(liste.get(i).getWeather().get(0).getDescription());
                    uhrzeit2.setText(uhrzeit);
                    break;
                case 3:
                    labelvor3.setIcon(icon);
                    description3.setText(liste.get(i).getWeather().get(0).getDescription());
                    uhrzeit3.setText(uhrzeit);
                    break;
                case 4:
                    labelvor4.setIcon(icon);
                    description4.setText(liste.get(i).getWeather().get(0).getDescription());
                    uhrzeit4.setText(uhrzeit);
                    break;
                case 5:
                    labelvor5.setIcon(icon);
                    description5.setText(liste.get(i).getWeather().get(0).getDescription());
                    uhrzeit5.setText(uhrzeit);
                    break;
                case 6:
                    labelvor6.setIcon(icon);
                    description6.setText(liste.get(i).getWeather().get(0).getDescription());
                    uhrzeit6.setText(uhrzeit);
                    break;
                case 7:
                    labelvor7.setIcon(icon);
                    description7.setText(liste.get(i).getWeather().get(0).getDescription());
                    uhrzeit7.setText(uhrzeit);
                    break;
                case 8:
                    labelvor8.setIcon(icon);
                    description8.setText(liste.get(i).getWeather().get(0).getDescription());
                    uhrzeit8.setText(uhrzeit);
                    break;
            }
            help++;
        }
    }

    public void changeDaten() throws ParseException, IOException {
        try{
            int index = liste.getSelectedIndex();
            String city = listmodel.getElementAt(index);
            fc = wc.getForecast(city);
            filterForecast();
            long dt = forecast_today.get(0).getDt();
            String name = fc.getDateString(dt);

            tfdate.setText(name);
            tftemperatur.setText(String.format("%.2f°C", forecast_today.get(0).getMain().getTemp() - 273.15));
            tftempmax.setText(String.format("%.2f°C", forecast_today.get(0).getMain().getTemp_max() - 273.15));
            tftempmin.setText(String.format("%.2f°C", forecast_today.get(0).getMain().getTemp_min() - 273.15));
            tfhumidity.setText(forecast_today.get(0).getMain().getHumidity() + " %");
            tfpressure.setText(forecast_today.get(0).getMain().getPressure() + "");
            setIcons(forecast_today);
        } catch (Exception e) {
            e.getMessage();
        }
    }
    
    /**
     * Buttons-Beschriftung für die Wettervorhersage 
     */
    public void setButtonDay() {
        try{
            SimpleDateFormat sdf = new SimpleDateFormat("EEEE");
            Date curreTime = new Date();
            btToday.setText("Heute");
            Calendar c = Calendar.getInstance();
            c.setTime(curreTime);
            c.add(Calendar.DAY_OF_WEEK, 1);
            btDay1.setText(sdf.format(c.getTime()));
            c.add(Calendar.DAY_OF_WEEK, 1);
            btDay2.setText(sdf.format(c.getTime()));
            c.add(Calendar.DAY_OF_WEEK, 1);
            btDay3.setText(sdf.format(c.getTime()));
            c.add(Calendar.DAY_OF_WEEK, 1);
            btDay4.setText(sdf.format(c.getTime()));
            c.add(Calendar.DAY_OF_WEEK, 1);
            btDay5.setText(sdf.format(c.getTime()));
        } catch (Exception e) {
            e.getMessage();
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(WeatherGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(WeatherGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(WeatherGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(WeatherGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new WeatherGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem Hummidity;
    private javax.swing.JMenuItem Pressure;
    private javax.swing.JMenuItem Temperture;
    private javax.swing.JButton btDay1;
    private javax.swing.JButton btDay2;
    private javax.swing.JButton btDay3;
    private javax.swing.JButton btDay4;
    private javax.swing.JButton btDay5;
    private javax.swing.JButton btToday;
    private javax.swing.JLabel description1;
    private javax.swing.JLabel description2;
    private javax.swing.JLabel description3;
    private javax.swing.JLabel description4;
    private javax.swing.JLabel description5;
    private javax.swing.JLabel description6;
    private javax.swing.JLabel description7;
    private javax.swing.JLabel description8;
    private javax.swing.JMenuItem hinzufuegen;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelvor1;
    private javax.swing.JLabel labelvor2;
    private javax.swing.JLabel labelvor3;
    private javax.swing.JLabel labelvor4;
    private javax.swing.JLabel labelvor5;
    private javax.swing.JLabel labelvor6;
    private javax.swing.JLabel labelvor7;
    private javax.swing.JLabel labelvor8;
    private javax.swing.JList<String> liste;
    private javax.swing.JMenuItem loeschen;
    private javax.swing.JMenu sort;
    private javax.swing.JTextField tfdate;
    private javax.swing.JTextField tfhumidity;
    private javax.swing.JTextField tfpressure;
    private javax.swing.JTextField tftemperatur;
    private javax.swing.JTextField tftempmax;
    private javax.swing.JTextField tftempmin;
    private javax.swing.JLabel uhrzeit1;
    private javax.swing.JLabel uhrzeit2;
    private javax.swing.JLabel uhrzeit3;
    private javax.swing.JLabel uhrzeit4;
    private javax.swing.JLabel uhrzeit5;
    private javax.swing.JLabel uhrzeit6;
    private javax.swing.JLabel uhrzeit7;
    private javax.swing.JLabel uhrzeit8;
    // End of variables declaration//GEN-END:variables
}
