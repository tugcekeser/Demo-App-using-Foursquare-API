package com.example.tuze.remindtakehome.Models;

import org.json.JSONException;
import org.json.JSONObject;

public class Todo {
    private Integer count;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Todo(JSONObject jsonObject) {

        try {
            this.count=jsonObject.getInt("count");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
