package com.example.tuze.remindtakehome.Models;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Geocode {
    private String what;
    private String where;

    public String getWhat() {
        return what;
    }

    public void setWhat(String what) {
        this.what = what;
    }

    public String getWhere() {
        return where;
    }

    public void setWhere(String where) {
        this.where = where;
    }


    public Geocode(JSONObject jsonObject) {
        try {
            this.what = jsonObject.getString("what");
            this.where = jsonObject.getString("where");

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Object> fromParentsJSONArray(JSONArray array) {
        ArrayList<Object> results = new ArrayList<Object>();
        for (int i = 0; i < array.length(); i++) {
            try {
                results.add(array.getJSONObject(i));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return results;
    }
}
