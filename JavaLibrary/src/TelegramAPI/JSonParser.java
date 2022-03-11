/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TelegramAPI;

import org.json.*;

/**
 *
 * @author baldassin_davide
 */
public class JSONParser {

    public void parseFromJSON(String jsonText) {

        //String jsonString = "{nome:'mario',messaggi:['ciao','mondo']}"; //assign your JSON String here
        JSONObject obj = new JSONObject(jsonText);
        /*String messageText = obj.getString("text");
        System.out.println(messageText);*/

        JSONArray result = obj.getJSONArray("result"); // notice that `"posts": [...]`
        for (int i = 0; i < result.length(); i++) {
            JSONObject message = result.getJSONObject("message");
            System.out.println(messaggio);
        }
    }
}
