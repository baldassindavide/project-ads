/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jappads;

import org.w3c.dom.Element;
import org.w3c.dom.Node;

/**
 *
 * @author baldassin_davide
 */
public class JTown {
    double lat,lon;
    String name;
    
    public JTown(){
        // default
    }
    
    public JTown(Node node){
        Element e = (Element)node;
        this.name = e.getAttribute("display_name");
        this.lat = Double.parseDouble(e.getAttribute("lat")); 
        this.lon = Double.parseDouble(e.getAttribute("lon")); 
    }
    public JTown(double lat, double lon, String name){
        this.lat = lat;
        this.lon = lon;
        this.name = name;
    }
    
    public String toString(){
        return "Lat: " + Double.toString(lat) + " / Lon: " 
                + Double.toString(lon) + " / Name: " + name; 
    }
}
