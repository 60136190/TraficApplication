package com.example.traficapplication.activities.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SignCategory {
    @SerializedName("image")
    @Expose
    private SignImage__1 image;
    @SerializedName("_id")
    @Expose
    private String id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("__v")
    @Expose
    private Integer v;

    public SignImage__1 getImage() {
        return image;
    }

    public void setImage(SignImage__1 image) {
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
