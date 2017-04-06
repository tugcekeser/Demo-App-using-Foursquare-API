package com.example.tuze.remindtakehome.Models;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Venue {
    private String id;
    private String name;
    private Contact contact;
    private Location location;
    private List<Category> categories = null;
    private Boolean verified;
    private Stats stats;
    private String url;
    private Double rating;
    private String ratingColor;
    private Integer ratingSignals;
    private BeenHere beenHere;
    private HereNow hereNow;
    private FeaturedPhotos featuredPhotos;
    private Boolean allowMenuUrlEdit;
    private Hours hours;
    private Boolean venueRatingBlacklisted;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public void setFeaturedPhotos(FeaturedPhotos featuredPhotos) {
        this.featuredPhotos = featuredPhotos;
    }

    public void setHours(Hours hours) {
        this.hours = hours;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public void setRatingColor(String ratingColor) {
        this.ratingColor = ratingColor;
    }

    public void setRatingSignals(Integer ratingSignals) {
        this.ratingSignals = ratingSignals;
    }

    public Boolean getVerified() {
        return verified;
    }

    public void setVerified(Boolean verified) {
        this.verified = verified;
    }

    public Stats getStats() {
        return stats;
    }

    public void setStats(Stats stats) {
        this.stats = stats;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Boolean getVenueRatingBlacklisted() {
        return venueRatingBlacklisted;
    }

    public void setVenueRatingBlacklisted(Boolean venueRatingBlacklisted) {
        this.venueRatingBlacklisted = venueRatingBlacklisted;
    }

    public BeenHere getBeenHere() {
        return beenHere;
    }

    public void setBeenHere(BeenHere beenHere) {
        this.beenHere = beenHere;
    }

    public HereNow getHereNow() {
        return hereNow;
    }

    public void setHereNow(HereNow hereNow) {
        this.hereNow = hereNow;
    }

    public Boolean getAllowMenuUrlEdit() {
        return allowMenuUrlEdit;
    }

    public void setAllowMenuUrlEdit(Boolean allowMenuUrlEdit) {
        this.allowMenuUrlEdit = allowMenuUrlEdit;
    }

    public Double getRating() {
        return rating;
    }

    public FeaturedPhotos getFeaturedPhotos() {
        return featuredPhotos;
    }

    public Hours getHours() {
        return hours;
    }

    public Integer getRatingSignals() {
        return ratingSignals;
    }

    public String getRatingColor() {
        return ratingColor;
    }

    public Venue(JSONObject jsonObject) {

        try {
            this.id = jsonObject.getString("id");
            this.name = jsonObject.getString("name");
            this.contact = new Contact(jsonObject.getJSONObject("contact"));
            this.location = new Location(jsonObject.getJSONObject("location"));
            this.featuredPhotos = new FeaturedPhotos(jsonObject.getJSONObject("featuredPhotos"));
            this.categories = fromCategoriesJSONArray(jsonObject.getJSONArray("categories"));
            this.verified = jsonObject.getBoolean("verified");
            this.stats = new Stats(jsonObject.getJSONObject("stats"));
            this.rating = jsonObject.getDouble("rating");
            this.ratingColor = jsonObject.getString("ratingColor");
            this.ratingSignals = jsonObject.getInt("ratingSignals");
            this.venueRatingBlacklisted = jsonObject.getBoolean("venueRatingBlacklisted");
            this.beenHere = new BeenHere(jsonObject.getJSONObject("beenHere"));
            this.hereNow = new HereNow(jsonObject.getJSONObject("hereNow"));
            this.hours = new Hours(jsonObject.getJSONObject("hours"));
            this.allowMenuUrlEdit = jsonObject.getBoolean("allowMenuUrlEdit");

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Category> fromCategoriesJSONArray(JSONArray array) {
        ArrayList<Category> results = new ArrayList<Category>();
        for (int i = 0; i < array.length(); i++) {
            try {
                results.add(new Category(array.getJSONObject(i)));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return results;
    }
}
