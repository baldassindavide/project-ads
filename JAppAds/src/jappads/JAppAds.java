/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jappads;

import TelegramAPI.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.List;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

/**
 *
 * @author baldassin_davide
 */
public class JAppAds {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, ParserConfigurationException, SAXException {

        JSonParser t = new JSonParser();
        OpenStreetMap OSM = new OpenStreetMap();

        URL url = new URL("https://api.telegram.org/bot5283513985:AAH1BGdQ2jeiQbxty_65JltrNSFFr-mvsXg/getUpdates");

        BufferedReader in;
        Boolean found = true;
        String singleLine, jsonText = "";
        in = new BufferedReader(new InputStreamReader(url.openStream()));
        do {
            singleLine = in.readLine();
            if (singleLine != null) {
                jsonText += singleLine;
            }
        } while (singleLine != null);

        String[] arrayMessage = t.parseFromJSON(jsonText).split(",");
        String message = arrayMessage[0];
        String chatID = arrayMessage[1];
        // System.out.println(t.parseFromJSON(jsonText));
        if (message.contains("/paese ")) {
            String[] arrayPaese = message.split(" ", 2);
            String paese = URLEncoder.encode(arrayPaese[1], "UTF-8");
            URL urlOSM = new URL("https://nominatim.openstreetmap.org/search?q=" + paese + "&format=xml&addressdetails=1");
            
            List listTown = OSM.getPaese(urlOSM);
            JTown town = OSM.getPaese(urlOSM).get(0);
            System.out.println(town.toString());
        }    
    }
}
