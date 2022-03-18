/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jappads;

import TelegramAPI.*;
import java.io.BufferedReader;
import java.io.FileWriter;
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
     * 
     */
    
   
    
    public static void main(String[] args) throws IOException, ParserConfigurationException, SAXException {

        JSonParser t = new JSonParser();
        OpenStreetMap OSM = new OpenStreetMap();
        TelegramAPI tAPI = new TelegramAPI("https://api.telegram.org/bot5283513985:AAH1BGdQ2jeiQbxty_65JltrNSFFr-mvsXg/");
        String jsonText = tAPI.getUpdates(); // gets all the messages
        
        String[] arrayMessage = t.parseFromJSON(jsonText).split(",");
        String message = arrayMessage[0]; // gets the last message and the chat id of the message
        String chatID = arrayMessage[1];
        
        // sends query to OpenStreetMap
        if (message.contains("/paese ")) {
            String[] arrayPaese = message.split(" ", 2);
            String paese = URLEncoder.encode(arrayPaese[1], "UTF-8");
            JTown town = OSM.getPaese(paese).get(0);
            
            String CSVText = chatID + ";" + town.getName() + ";" + Double.toString(town.getLat()) + ";" + Double.toString(town.getLon()) + "\r\n";
            writeOnFile("data.csv", CSVText); // writes on CSV file
            
            
        }
    }
    
    public static String getDataFromTelegramURL(URL url) throws IOException{
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
        
        return jsonText;
    }
    
    public static void writeOnFile(String file, String text) throws IOException {
        FileWriter myWriter = new FileWriter(file, true);
        myWriter.write(text);
        myWriter.close();
    }
}
