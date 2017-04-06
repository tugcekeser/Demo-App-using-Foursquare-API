package com.example.tuze.remindtakehome.Models;

import org.json.JSONException;
import org.json.JSONObject;

public class Category {
    private String id;
    private String name;
    private String pluralName;
    private String shortName;
    private Icon icon;
    private Boolean primary;

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

    public String getPluralName() {
        return pluralName;
    }

    public void setPluralName(String pluralName) {
        this.pluralName = pluralName;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public Icon getIcon() {
        return icon;
    }

    public void setIcon(Icon icon) {
        this.icon = icon;
    }

    public Boolean getPrimary() {
        return primary;
    }

    public void setPrimary(Boolean primary) {
        this.primary = primary;
    }

    public Category(JSONObject jsonObject) {
        try {
            this.id = jsonObject.getString("id");
            this.name = jsonObject.getString("name");
            this.pluralName = jsonObject.getString("pluralName");
            this.shortName = jsonObject.getString("shortName");
            this.icon = new Icon(jsonObject.getJSONObject("icon"));
            this.primary = jsonObject.getBoolean("primary");

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
