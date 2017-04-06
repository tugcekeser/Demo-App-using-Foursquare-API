package com.example.tuze.remindtakehome.Models;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Group {
    private String type;
    private String name;
    private Integer count;
    private List<Object> items = null;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<Object> getItems() {
        return items;
    }

    public void setItems(List<Object> items) {
        this.items = items;
    }

    public Group(JSONObject jsonObject) {
        try {
            this.type = jsonObject.getString("type");
            this.name = jsonObject.getString("name");
            this.count = jsonObject.getInt("count");
            this.items = fromItemsJSONArray(jsonObject.getJSONArray("items"));

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Object> fromItemsJSONArray(JSONArray array) {
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
