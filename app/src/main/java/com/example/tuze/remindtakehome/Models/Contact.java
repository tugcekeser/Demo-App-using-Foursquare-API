package com.example.tuze.remindtakehome.Models;

import org.json.JSONException;
import org.json.JSONObject;

public class Contact {
    private String twitter;
    private String facebook;
    private String facebookUsername;
    private String facebookName;
    private String phone;
    private String formattedPhone;

    public String getTwitter() {
        return twitter;
    }

    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public String getFacebookUsername() {
        return facebookUsername;
    }

    public void setFacebookUsername(String facebookUsername) {
        this.facebookUsername = facebookUsername;
    }

    public String getFacebookName() {
        return facebookName;
    }

    public void setFacebookName(String facebookName) {
        this.facebookName = facebookName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFormattedPhone() {
        return formattedPhone;
    }

    public void setFormattedPhone(String formattedPhone) {
        this.formattedPhone = formattedPhone;
    }

    public Contact(JSONObject jsonObject) {
        try {
            this.twitter = jsonObject.getString("twitter");
            this.facebook = jsonObject.getString("facebook");
            this.facebookName = jsonObject.getString("facebookName");
            this.facebookUsername = jsonObject.getString("facebookUsername");
            this.phone = jsonObject.getString("phone");
            this.formattedPhone = jsonObject.getString("formattedPhone");

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
