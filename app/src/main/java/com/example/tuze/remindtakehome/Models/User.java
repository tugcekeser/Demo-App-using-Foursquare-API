package com.example.tuze.remindtakehome.Models;

import org.json.JSONException;
import org.json.JSONObject;

public class User {
    private String id;
    private String firstName;
    private String lastName;
    private String gender;
    private Photo photo;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Photo getPhoto() {
        return photo;
    }

    public void setPhoto(Photo photo) {
        this.photo = photo;
    }

    public User(JSONObject jsonObject) {
        try {
            this.id=jsonObject.getString("id");
            this.firstName=jsonObject.getString("firstName");
            this.lastName=jsonObject.getString("lastName");
            this.gender=jsonObject.getString("gender");
            this.photo=new Photo(jsonObject.getJSONObject("photo"));

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
