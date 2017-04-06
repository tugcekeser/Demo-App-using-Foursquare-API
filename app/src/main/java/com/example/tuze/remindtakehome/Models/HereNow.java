package com.example.tuze.remindtakehome.Models;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class HereNow {
    private Integer count;
    private String summary;
    private List<Group> groups = null;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public List<Group> getGroups() {
        return groups;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }

    public HereNow(JSONObject jsonObject) {
        try {
            this.count = jsonObject.getInt("count");
            this.summary = jsonObject.getString("summary");
            this.groups = fromGroupsJSONArray(jsonObject.getJSONArray("groups"));

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Group> fromGroupsJSONArray(JSONArray array) {
        ArrayList<Group> results = new ArrayList<Group>();
        for (int i = 0; i < array.length(); i++) {
            try {
                results.add(new Group(array.getJSONObject(i)));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return results;
    }
}
