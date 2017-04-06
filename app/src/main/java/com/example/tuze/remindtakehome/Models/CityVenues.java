package com.example.tuze.remindtakehome.Models;

import org.json.JSONException;
import org.json.JSONObject;

public class CityVenues {
    private Meta meta;
    private ResponseVenue response;

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    public ResponseVenue getResponse() {
        return response;
    }

    public void setResponse(ResponseVenue response) {
        this.response = response;
    }


    public CityVenues(JSONObject jsonObject) {
        try {
            this.meta = new Meta(jsonObject.getJSONObject("meta"));
            this.response = new ResponseVenue(jsonObject.getJSONObject("response"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
