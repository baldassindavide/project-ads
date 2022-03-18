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
public class JSonParser {

    public String parseFromJSON(String jsonText) {

        //String jsonString = "{nome:'mario',messaggi:['ciao','mondo']}"; //assign your JSON String here
        JSONObject obj = new JSONObject(jsonText);
        /*String messageText = obj.getString("text");
        System.out.println(messageText);*/

        JSONArray arrayResult = obj.getJSONArray("result"); // notice that `"result": [...]`
        //for (int i = 0; i < arrayResult.length(); i++) {
        JSONObject arrayObj = arrayResult.getJSONObject(arrayResult.length() - 1);
        JSONObject message = arrayObj.getJSONObject("message");
        String text = message.getString("text");
        
        JSONObject chat = message.getJSONObject("chat");
        int chatID = chat.getInt("id");
        //System.out.println(text);        
        return text + "," + chatID;
    }
}
