package com.example.tuze.remindtakehome.Models;

import org.json.JSONException;
import org.json.JSONObject;

public class Icon {
    private String prefix;
    private String suffix;

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public Icon(JSONObject jsonObject) {

        try {
            this.prefix = jsonObject.getString("prefix");
            this.suffix = jsonObject.getString("suffix");

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
