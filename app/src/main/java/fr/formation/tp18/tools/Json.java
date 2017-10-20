package fr.formation.tp18.tools;

import android.util.Log;

import org.apache.commons.io.IOUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import fr.formation.tp18.modele.User;

/**
 * Created by ronan on 06/06/2017.
 */

public class Json {

    private static final String TAG = Json.class.getSimpleName();

    public Json() {
    }

    public String getJsonFrom(String reqUrl) {
        String response = null;
        try {
            response = IOUtils.toString(new URL(reqUrl));
        } catch (Exception e) {
            Log.e(TAG, "Exception: " + e.getMessage());
        }
        return response;
    }

    public List<User> jsonToUsers(String jsonStr) {
        List<User> users = new ArrayList<>();
        if (jsonStr != null) {
            try {
                JSONObject jsonObj = new JSONObject(jsonStr);
                // Getting JSON Array node
                JSONArray contacts = jsonObj.getJSONArray("offres");
                // looping through All Contacts
                for (int i = 0; i < contacts.length(); i++) {
                    JSONObject c = contacts.getJSONObject(i);
                    users.add(new User(c.getString("nom"), c.getString("annonce")));
                }
            } catch (final JSONException e) {
                Log.e(TAG, "Json parsing error: " + e.getMessage());
            }

        }
        return users;
    }

}
