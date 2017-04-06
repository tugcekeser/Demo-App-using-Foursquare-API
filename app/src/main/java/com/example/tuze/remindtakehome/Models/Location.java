package com.example.tuze.remindtakehome.Models;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Location {
    private Double lat;
    private Double lng;
    private String postalCode;
    private String cc;
    private String state;
    private String country;
    private List<String> formattedAddress = null;
    private String address;
    private String crossStreet;
    private List<LabeledLatLng> labeledLatLngs = null;
    private String city;

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

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCc() {
        return cc;
    }

    public void setCc(String cc) {
        this.cc = cc;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public List<String> getFormattedAddress() {
        return formattedAddress;
    }

    public void setFormattedAddress(List<String> formattedAddress) {
        this.formattedAddress = formattedAddress;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCrossStreet() {
        return crossStreet;
    }

    public void setCrossStreet(String crossStreet) {
        this.crossStreet = crossStreet;
    }

    public List<LabeledLatLng> getLabeledLatLngs() {
        return labeledLatLngs;
    }

    public void setLabeledLatLngs(List<LabeledLatLng> labeledLatLngs) {
        this.labeledLatLngs = labeledLatLngs;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }


    public Location(JSONObject jsonObject) {
        try {
            this.lat = jsonObject.getDouble("lat");
            this.lng = jsonObject.getDouble("lng");
            this.postalCode = jsonObject.getString("postalCode");
            this.cc = jsonObject.getString("cc");
            this.state = jsonObject.getString("state");
            this.country = jsonObject.getString("country");
            this.formattedAddress = fromFormattedAddressJSONArray(jsonObject.getJSONArray("formattedAddress"));
            this.address = jsonObject.getString("address");
            this.crossStreet = jsonObject.getString("crossStreet");
            this.labeledLatLngs = fromLabeledLatLngsJSONArray(jsonObject.getJSONArray("labeledLatLngs"));
            this.city = jsonObject.getString("city");

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<String> fromFormattedAddressJSONArray(JSONArray array) {
        ArrayList<String> results = new ArrayList<String>();
        for (int i = 0; i < array.length(); i++) {
            try {
                results.add(array.getString(i));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return results;
    }

    public static ArrayList<LabeledLatLng> fromLabeledLatLngsJSONArray(JSONArray array) {
        ArrayList<LabeledLatLng> results = new ArrayList<LabeledLatLng>();
        for (int i = 0; i < array.length(); i++) {
            try {
                results.add(new LabeledLatLng(array.getJSONObject(i)));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return results;
    }
}
