package com.example.tuze.remindtakehome.Models;

import org.json.JSONException;
import org.json.JSONObject;

public class Stats {
    private Integer checkinsCount;
    private Integer usersCount;
    private Integer tipCount;

    public Integer getCheckinsCount() {
        return checkinsCount;
    }

    public void setCheckinsCount(Integer checkinsCount) {
        this.checkinsCount = checkinsCount;
    }

    public Integer getUsersCount() {
        return usersCount;
    }

    public void setUsersCount(Integer usersCount) {
        this.usersCount = usersCount;
    }

    public Integer getTipCount() {
        return tipCount;
    }

    public void setTipCount(Integer tipCount) {
        this.tipCount = tipCount;
    }

    public Stats(JSONObject jsonObject) {
        try {
            this.checkinsCount = jsonObject.getInt("checkinsCount");
            this.usersCount = jsonObject.getInt("usersCount");
            this.tipCount = jsonObject.getInt("tipCount");

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
