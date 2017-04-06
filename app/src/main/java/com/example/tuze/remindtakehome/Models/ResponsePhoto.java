package com.example.tuze.remindtakehome.Models;

import org.json.JSONException;
import org.json.JSONObject;

public class ResponsePhoto {
    private Photos photos;

    public Photos getPhotos() {
        return photos;
    }

    public void setPhotos(Photos photos) {
        this.photos = photos;
    }


    public ResponsePhoto(JSONObject jsonObject) {
        try {
          this.photos=new Photos(jsonObject.getJSONObject("photos"));

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
