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

        JSONArray arrayResult = obj.getJSONArray("result"); // notice that `"posts": [...]`
        for (int i = 0; i < arrayResult.length(); i++) {
            JSONObject arrayObj = arrayResult.getJSONObject(i);
            JSONObject message = arrayObj.getJSONObject("message");
            String text = message.getString("text");
            System.out.println(text);
        }
    }
}
