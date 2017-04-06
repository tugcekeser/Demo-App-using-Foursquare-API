package com.example.tuze.remindtakehome.Models;

import org.json.JSONException;
import org.json.JSONObject;

public class LabeledLatLng {

    private String label;
    private Double lat;
    private Double lng;

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLng() {
        return lng;
    }

    public void setLng(Double lng) {
        this.lng = lng;
    }

    public LabeledLatLng(JSONObject jsonObject) {

        try {
            this.label = jsonObject.getString("label");
            this.lat = jsonObject.getDouble("lat");
            this.lng = jsonObject.getDouble("lng");

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
