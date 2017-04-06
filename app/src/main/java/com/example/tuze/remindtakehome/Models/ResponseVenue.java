package com.example.tuze.remindtakehome.Models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ResponseVenue {
    private Geocode geocode;
    private List<GroupExplore> groups = null;

    public Geocode getGeocode() {
        return geocode;
    }

    public void setGeocode(Geocode geocode) {
        this.geocode = geocode;
    }

    public void setGroups(List<GroupExplore> groups) {
        this.groups = groups;
    }

    public List<GroupExplore> getGroups() {
        return groups;
    }

    public ResponseVenue(JSONObject jsonObject) {
        try {
            this.geocode=new Geocode(jsonObject.getJSONObject("geocode"));
            this.groups=fromGroupsJSONArray(jsonObject.getJSONArray("groups"));

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<GroupExplore> fromGroupsJSONArray(JSONArray array) {
        ArrayList<GroupExplore> results = new ArrayList<GroupExplore>();
        for (int i = 0; i < array.length(); i++) {
            try {
                results.add(new GroupExplore(array.getJSONObject(i)));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return results;
    }
}
