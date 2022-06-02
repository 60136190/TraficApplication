package com.example.traficapplication.activities.models;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Sign {
    @SerializedName("image")
    @Expose
    private SignImage signImage;
    @SerializedName("_id")
    @Expose
    private String id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("code")
    @Expose
    private String code;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("category")
    @Expose
    private Category category;
    @SerializedName("__v")
    @Expose
    private Integer v;

    public SignImage getImage() {
        return signImage;
    }

    public void setImage(SignImage signImage) {
        this.signImage = signImage;
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Integer getV() {
        return v;
    }

    public void setV(Integer v) {
        this.v = v;
    }

}




