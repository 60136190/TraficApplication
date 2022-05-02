package com.example.traficapplication.activities.models;

public class ItemLaw {
    private int imgItemLaw;
    private String tittleItemLaw,contentItemLaw,detailItemLaw;


    public ItemLaw(int imgItemLaw, String tittleItemLaw, String contentItemLaw, String detailItemLaw) {
        this.imgItemLaw = imgItemLaw;
        this.tittleItemLaw = tittleItemLaw;
        this.contentItemLaw = contentItemLaw;
        this.detailItemLaw = detailItemLaw;
    }

    public int getImgItemLaw() {
        return imgItemLaw;
    }

    public void setImgItemLaw(int imgItemLaw) {
        this.imgItemLaw = imgItemLaw;
    }

    public String getTittleItemLaw() {
        return tittleItemLaw;
    }

    public void setTittleItemLaw(String tittleItemLaw) {
        this.tittleItemLaw = tittleItemLaw;
    }

    public String getContentItemLaw() {
        return contentItemLaw;
    }

    public void setContentItemLaw(String contentItemLaw) {
        this.contentItemLaw = contentItemLaw;
    }

    public String getDetailItemLaw() {
        return detailItemLaw;
    }

    public void setDetailItemLaw(String detailItemLaw) {
        this.detailItemLaw = detailItemLaw;
    }
}
