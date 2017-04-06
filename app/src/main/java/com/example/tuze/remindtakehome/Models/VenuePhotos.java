package com.example.tuze.remindtakehome.Models;

import org.json.JSONException;
import org.json.JSONObject;

public class VenuePhotos {
    private Meta meta;
    private ResponsePhoto response;

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    public ResponsePhoto getResponse() {
        return response;
    }

    public void setResponse(ResponsePhoto response) {
        this.response = response;
    }

    public VenuePhotos(JSONObject jsonObject) {
        try {
            this.meta = new Meta(jsonObject.getJSONObject("meta"));
            this.response = new ResponsePhoto(jsonObject.getJSONObject("response"));

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
