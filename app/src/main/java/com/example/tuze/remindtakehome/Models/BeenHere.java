package com.example.tuze.remindtakehome.Models;

import org.json.JSONException;
import org.json.JSONObject;

public class BeenHere {
    private Integer count;
    private Boolean marked;
    private Integer lastCheckinExpiredAt;

    public Integer getLastCheckinExpiredAt() {
        return lastCheckinExpiredAt;
    }

    public void setLastCheckinExpiredAt(Integer lastCheckinExpiredAt) {
        this.lastCheckinExpiredAt = lastCheckinExpiredAt;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getCount() {
        return count;
    }

    public void setMarked(Boolean marked) {
        this.marked = marked;
    }

    public Boolean getMarked() {
        return marked;
    }

    public BeenHere(JSONObject jsonObject) {
        try {
            this.lastCheckinExpiredAt = jsonObject.getInt("lastCheckinExpiredAt");
            this.count = jsonObject.getInt("count");
            this.marked = jsonObject.getBoolean("marked");

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
