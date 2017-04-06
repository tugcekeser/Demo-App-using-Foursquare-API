package com.example.tuze.remindtakehome.Models;

import org.json.JSONException;
import org.json.JSONObject;

public class Hours {
    private String status;
    private Boolean isOpen;
    private Boolean isLocalHoliday;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Boolean getIsOpen() {
        return isOpen;
    }

    public void setIsOpen(Boolean isOpen) {
        this.isOpen = isOpen;
    }

    public Boolean getIsLocalHoliday() {
        return isLocalHoliday;
    }

    public void setIsLocalHoliday(Boolean isLocalHoliday) {
        this.isLocalHoliday = isLocalHoliday;
    }

    public Hours(JSONObject jsonObject) {
        try {
            this.status = jsonObject.getString("status");
            this.isLocalHoliday = jsonObject.getBoolean("isLocalHoliday");
            this.isOpen = jsonObject.getBoolean("isOpen");

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
