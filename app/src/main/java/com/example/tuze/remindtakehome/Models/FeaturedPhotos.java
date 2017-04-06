package com.example.tuze.remindtakehome.Models;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class FeaturedPhotos {
    private Integer count;
    private List<Item> items = null;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public FeaturedPhotos(JSONObject jsonObject) {
        try {
            this.count = jsonObject.getInt("count");
            this.items = fromItemsJSONArray(jsonObject.getJSONArray("items"));

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Item> fromItemsJSONArray(JSONArray array) {
        ArrayList<Item> results = new ArrayList<Item>();
        for (int i = 0; i < array.length(); i++) {
            try {
                results.add(new Item(array.getJSONObject(i)));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return results;
    }
}
