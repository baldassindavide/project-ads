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
public class JTest {

    public void foo() {

        String jsonString = "{nome:'mario',messaggi:['ciao','mondo']}"; //assign your JSON String here
        JSONObject obj = new JSONObject(jsonString);
        String nome = obj.getString("nome");
        System.out.println(nome);

        JSONArray arr = obj.getJSONArray("messaggi"); // notice that `"posts": [...]`
        for (int i = 0; i < arr.length(); i++) {
            String messaggio = arr.getString(i);
            System.out.println(messaggio);
        }
    }
}
