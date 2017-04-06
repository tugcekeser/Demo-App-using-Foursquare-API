package com.example.tuze.remindtakehome.Models;

import org.json.JSONException;
import org.json.JSONObject;

public class Source {
    private String name;
    private String url;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Source(JSONObject jsonObject) {
        try {
            this.name = jsonObject.getString("name");
            this.url = jsonObject.getString("url");

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
