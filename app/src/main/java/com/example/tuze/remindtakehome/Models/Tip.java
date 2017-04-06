package com.example.tuze.remindtakehome.Models;

import org.json.JSONException;
import org.json.JSONObject;

public class Tip {
    private String id;
    private Integer createdAt;
    private String text;
    private String type;
    private String canonicalUrl;
    private Boolean logView;
    private Integer agreeCount;
    private Integer disagreeCount;
    private Todo todo;

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

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCanonicalUrl() {
        return canonicalUrl;
    }

    public void setCanonicalUrl(String canonicalUrl) {
        this.canonicalUrl = canonicalUrl;
    }

    public Boolean getLogView() {
        return logView;
    }

    public void setLogView(Boolean logView) {
        this.logView = logView;
    }

    public Integer getAgreeCount() {
        return agreeCount;
    }

    public void setAgreeCount(Integer agreeCount) {
        this.agreeCount = agreeCount;
    }

    public Integer getDisagreeCount() {
        return disagreeCount;
    }

    public void setDisagreeCount(Integer disagreeCount) {
        this.disagreeCount = disagreeCount;
    }

    public Todo getTodo() {
        return todo;
    }

    public void setTodo(Todo todo) {
        this.todo = todo;
    }

    public Tip(JSONObject jsonObject) {

        try {
            this.id=jsonObject.getString("id");
            this.createdAt=jsonObject.getInt("createdAt");
            this.text=jsonObject.getString("text");
            this.type=jsonObject.getString("type");
            this.canonicalUrl=jsonObject.getString("canonicalUrl");
            this.logView=jsonObject.getBoolean("logView");
            this.agreeCount=jsonObject.getInt("agreeCount");
            this.disagreeCount=jsonObject.getInt("disagreeCount");
            this.todo=new Todo(jsonObject.getJSONObject("todo"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
