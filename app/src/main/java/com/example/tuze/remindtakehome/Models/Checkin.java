package com.example.tuze.remindtakehome.Models;

import org.json.JSONException;
import org.json.JSONObject;

public class Checkin {
    private String id;
    private Integer createdAt;
    private String type;
    private Integer timeZoneOffset;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Integer createdAt) {
        this.createdAt = createdAt;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getTimeZoneOffset() {
        return timeZoneOffset;
    }

    public void setTimeZoneOffset(Integer timeZoneOffset) {
        this.timeZoneOffset = timeZoneOffset;
    }

    public Checkin(JSONObject jsonObject) {
        try {
            this.id = jsonObject.getString("id");
            this.createdAt = jsonObject.getInt("createdAt");
            this.type = jsonObject.getString("type");
            this.timeZoneOffset = jsonObject.getInt("timeZoneOffset");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
