package com.example.tuze.remindtakehome.Models;

import org.json.JSONException;
import org.json.JSONObject;

public class Meta {
    private Integer code;
    private String requestId;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public Meta(JSONObject jsonObject) {
        try {
            this.code = jsonObject.getInt("code");
            this.requestId = jsonObject.getString("requestId");

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
