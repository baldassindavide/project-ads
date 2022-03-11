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



/**
 *
 * @author baldassin_davide
 */
public class JAppAds {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        
        JSONParser t = new JSONParser();
       
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
        
        t.parseFromJSON(jsonText);


    }

}
