package com.example.tuze.remindtakehome.Models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class GroupExplore {
    private String type;
    private String name;
    private List<ItemExplore> items;

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

    public List<ItemExplore> getItems() {
        return items;
    }

    public void setItems(List<ItemExplore> items) {
        this.items = items;
    }

    public GroupExplore(JSONObject jsonObject) {
        try {
            this.type = jsonObject.getString("type");
            this.name = jsonObject.getString("name");
            this.items = fromItemsJSONArray(jsonObject.getJSONArray("items"));

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<ItemExplore> fromItemsJSONArray(JSONArray array) {
        ArrayList<ItemExplore> results = new ArrayList<ItemExplore>();
        for (int i = 0; i < array.length(); i++) {
            try {
                results.add(new ItemExplore(array.getJSONObject(i)));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return results;
    }
}
