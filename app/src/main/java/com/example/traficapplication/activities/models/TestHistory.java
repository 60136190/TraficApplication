package com.example.traficapplication.activities.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TestHistory {

    @SerializedName("_id")
    @Expose
    private String id;
    @SerializedName("mark")
    @Expose
    private String mark;
    @SerializedName("idUser")
    @Expose
    private String idUser;
    @SerializedName("__v")
    @Expose
    private Integer v;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public Integer getV() {
        return v;
    }

    public void setV(Integer v) {
        this.v = v;
    }
}
