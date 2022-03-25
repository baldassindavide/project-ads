/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TelegramAPI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

/**
 *
 * @author balda
 */
public class TelegramAPI {

    String url;

    public TelegramAPI(String url) {
        this.url = url;
    }

    public String getUpdates() throws IOException { // get updates
        url = "https://nominatim.openstreetmap.org/search?q=getUpdates";
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

    public void sendMessage(int chatID, String text) throws UnsupportedEncodingException, MalformedURLException, IOException {
        String textToSend = URLEncoder.encode(text, "UTF-8"); // url encoder
        url = "https://nominatim.openstreetmap.org/search?q=sendMessage?chat_id=" + Integer.toString(chatID) + "&text=" + textToSend; // create the API URL
        URL finalUrl = new URL(url);
        finalUrl.openStream();
    }
}
