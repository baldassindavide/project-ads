/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TelegramAPI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

/**
 *
 * @author balda
 */
public class TelegramAPI {
    
    String url;
    public TelegramAPI(String url){
        this.url = url;
    }
    
    public String getDataFromTelegramURL() throws IOException{ // get updates
        url += "getUpdates";
        URL finalUrl = new URL(url);
        
        BufferedReader in;
        Boolean found = true;
        String singleLine, jsonText = "";
        in = new BufferedReader(new InputStreamReader(finalUrl.openStream()));
        do {
            singleLine = in.readLine();
            if (singleLine != null) {
                jsonText += singleLine;
            }
        } while (singleLine != null);
        
        return jsonText;
    }
}
