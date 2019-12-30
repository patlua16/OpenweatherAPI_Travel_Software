/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bl;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import javax.print.attribute.standard.Destination;
import javax.swing.AbstractListModel; 
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;
import sort.SortbyHumidity;
import sort.SortbyPressure;
import sort.SortbyTemperatur;

/**
 * @author lukas
 */
public class DestinationListModel extends AbstractListModel<String>{

    private List<String> destination; 
    
    /**
     * Konstruktor 
     */
    public DestinationListModel() {
        this.destination = new LinkedList();;
    } 
    
    /**
     * Methode um die Größe der Liste zu bekommen
     * @return Size von der Destination-Liste
     */
    @Override
    public int getSize() {
       return this.destination.size();
    }
    
    /**
     * Methode zum Adden einer Destination
     * @param destinationName Dieser Name soll zur Liste hinzugefügt werden
     */
    public void add(String destinationName)
    {
        this.destination.add(destinationName);
        this.fireIntervalAdded(this, 0, this.getSize()-1);
    }

    /**
     * Die Destination-List als XML abspeichern
     * @param destination 
     * @throws IOException
     * @throws JDOMException 
     */
    public void saveXML(List<String> destination) throws IOException, JDOMException
    { 
         Element root = new Element("destinations");
         Document doc = new Document(root); 
         for (String dest : destination) {
            Element desti = new Element("destination");
            desti.setText(dest);
            root.addContent(desti);
        }
        XMLOutputter xmpOutput = new XMLOutputter();
        xmpOutput.setFormat(Format.getPrettyFormat()); 
        FileWriter writer = new FileWriter(new File("src/main/java/storage/destinations.xml"));
         xmpOutput.output(doc, writer);
    }
    
    /**
     * Die .xml Datei in die Liste laden
     * @throws JDOMException
     * @throws IOException 
     */
    public void loadXML() throws JDOMException, IOException
    {
        File inputFile = new File("src/main/java/storage/destinations.xml");
        SAXBuilder saxBuilder = new SAXBuilder();
        Document document = saxBuilder.build(inputFile);
        
        List<String> destinations = new LinkedList<>();
        List<Element> lvl1 = document.getRootElement().getChildren();
        for (Element element : lvl1) {
            destinations.add(element.getText());
        } 
       destination = new LinkedList<>();
        for (String desti : destinations) {
            destination.add(desti);
        } 
    }
    
    /**
     * Liste nach Temperture sortieren
     */
    public void sortByTemperature() {
        Collections.sort(destination, new SortbyTemperatur());
        this.fireContentsChanged(this, 0, destination.size() - 1);
    }
    
    /**
     * Nach Pressure sortieren
     */
    public void sortByPressure() {
        Collections.sort(destination, new SortbyPressure());
        this.fireContentsChanged(this, 0, destination.size() - 1);
    }
    
    /**
     * nach Humidity sortieren
     */
    public void sortByHumidity() {
        Collections.sort(destination, new SortbyHumidity());
        this.fireContentsChanged(this, 0, destination.size() - 1);
    }
    

    /**
     * Die Destination-Liste zu getten
     * @return 
     */
    public List<String> getDestination() {
        return destination;
    }  
    
    /**
     * Methode zum löschen eines Elementes aus der Liste
     * @param index 
     */
    public void delete(int index)
    {
        this.destination.remove(index);
        this.fireIntervalRemoved(this, 0, this.destination.size());
    }

    /**
     * Ein bestimmtes Element von der Liste zurückbekommen
     * @param index
     * @return 
     */
    @Override
    public String getElementAt(int index) {
       return this.destination.get(index);
    }
     
}
