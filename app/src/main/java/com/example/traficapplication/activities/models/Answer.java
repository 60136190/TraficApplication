package com.example.traficapplication.activities.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Answer {
    @SerializedName("true")
    @Expose
    private String _true;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("_id")
    @Expose
    private String id;

    public String getTrue() {
        return _true;
    }

    public void setTrue(String _true) {
        this._true = _true;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
