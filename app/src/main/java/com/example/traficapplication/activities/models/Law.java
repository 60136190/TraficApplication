package com.example.traficapplication.activities.models;

public class Law {
    private int imgLaw;
    private String typeLaw;

    public Law(int imgLaw, String typeLaw) {
        this.imgLaw = imgLaw;
        this.typeLaw = typeLaw;
    }

    public int getImgLaw() {
        return imgLaw;
    }

    public void setImgLaw(int imgLaw) {
        this.imgLaw = imgLaw;
    }

    public String getTypeLaw() {
        return typeLaw;
    }

    public void setTypeLaw(String typeLaw) {
        this.typeLaw = typeLaw;
    }
}
