package com.encle.emicalculator.Adapters;

import com.encle.emicalculator.Model.insurance_model;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class insurance_adapter {
    public static List<insurance_model> parseJson(String jsonString) {
        List<insurance_model> insuranceItems = new ArrayList<>();
        try {
            JSONArray jsonArray = new JSONArray(jsonString);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                int id = jsonObject.getInt("id");
                String title = jsonObject.getString("title");
                String description = jsonObject.getString("description");
                insuranceItems.add(new insurance_model(id, title, description));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return insuranceItems;
    }
}
