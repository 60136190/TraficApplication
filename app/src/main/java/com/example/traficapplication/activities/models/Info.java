package com.example.traficapplication.activities.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Info {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("tensp")
    @Expose
    private String tensp;
    @SerializedName("chitiet")
    @Expose
    private String chitiet;
    @SerializedName("size")
    @Expose
    private String size;
    @SerializedName("gia")
    @Expose
    private Integer gia;
    @SerializedName("public_id")
    @Expose
    private String publicId;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("id_dm")
    @Expose
    private Integer idDm;
    @SerializedName("tendm")
    @Expose
    private String tendm;
    @SerializedName("createdAt")
    @Expose
    private String createdAt;
    @SerializedName("updatedAt")
    @Expose
    private String updatedAt;
    @SerializedName("deleted_fg")
    @Expose
    private Integer deletedFg;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTensp() {
        return tensp;
    }

    public void setTensp(String tensp) {
        this.tensp = tensp;
    }

    public String getChitiet() {
        return chitiet;
    }

    public void setChitiet(String chitiet) {
        this.chitiet = chitiet;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public Integer getGia() {
        return gia;
    }

    public void setGia(Integer gia) {
        this.gia = gia;
    }

    public String getPublicId() {
        return publicId;
    }

    public void setPublicId(String publicId) {
        this.publicId = publicId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getIdDm() {
        return idDm;
    }

    public void setIdDm(Integer idDm) {
        this.idDm = idDm;
    }

    public String getTendm() {
        return tendm;
    }

    public void setTendm(String tendm) {
        this.tendm = tendm;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Integer getDeletedFg() {
        return deletedFg;
    }

    public void setDeletedFg(Integer deletedFg) {
        this.deletedFg = deletedFg;
    }

}
