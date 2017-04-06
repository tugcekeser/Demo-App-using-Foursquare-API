package com.example.tuze.remindtakehome.Models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ItemExplore {
    private Venue venue;
    private List<Tip> tips = null;
    private String referralId;

    public Venue getVenue() {
        return venue;
    }

    public void setVenue(Venue venue) {
        this.venue = venue;
    }

    public List<Tip> getTips() {
        return tips;
    }

    public void setTips(List<Tip> tips) {
        this.tips = tips;
    }

    public String getReferralId() {
        return referralId;
    }

    public void setReferralId(String referralId) {
        this.referralId = referralId;
    }

    public ItemExplore(JSONObject jsonObject) {
        try {
            this.venue = new Venue(jsonObject.getJSONObject("venue"));
            this.referralId = jsonObject.getString("referralId");
            this.tips = fromTipsJSONArray(jsonObject.getJSONArray("tips"));

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Tip> fromTipsJSONArray(JSONArray array) {
        ArrayList<Tip> results = new ArrayList<Tip>();
        for (int i = 0; i < array.length(); i++) {
            try {
                results.add(new Tip(array.getJSONObject(i)));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return results;
    }
}
