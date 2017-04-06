package com.example.tuze.remindtakehome.Models;

import org.json.JSONException;
import org.json.JSONObject;

public class Item {
    private String id;
    private Integer createdAt;
    private String prefix;
    private String suffix;
    private Integer width;
    private Integer height;
    private User user;

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

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Item(JSONObject jsonObject) {
        try {
            this.id = jsonObject.getString("id");
            this.createdAt = jsonObject.getInt("createdAt");
            this.prefix = jsonObject.getString("prefix");
            this.suffix = jsonObject.getString("suffix");
            this.width = jsonObject.getInt("width");
            this.height = jsonObject.getInt("height");
            this.user = new User(jsonObject.getJSONObject("user"));

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
