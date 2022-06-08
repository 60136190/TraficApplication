package com.example.traficapplication.activities.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class QuestionCategory {
    @SerializedName("image")
    @Expose
    private QuestionImage__1 image;
    @SerializedName("_id")
    @Expose
    private String id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("__v")
    @Expose
    private Integer v;

    public QuestionImage__1 getImage() {
        return image;
    }

    public void setImage(QuestionImage__1 image) {
        this.image = image;
    }

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

    public Integer getV() {
        return v;
    }

    public void setV(Integer v) {
        this.v = v;
    }

}
