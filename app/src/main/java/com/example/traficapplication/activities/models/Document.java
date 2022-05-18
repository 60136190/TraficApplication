package com.example.traficapplication.activities.models;

public class Document {
    private int imgDocument;
    private String tittleDocument;
    private String detailDocument;
    private int seekBarNum;

    public Document(int imgDocument, String tittleDocument, String detailDocument, int seekBarNum) {
        this.imgDocument = imgDocument;
        this.tittleDocument = tittleDocument;
        this.detailDocument = detailDocument;
        this.seekBarNum = seekBarNum;
    }

    public int getImgDocument() {
        return imgDocument;
    }

    public void setImgDocument(int imgDocument) {
        this.imgDocument = imgDocument;
    }

    public String getTittleDocument() {
        return tittleDocument;
    }

    public void setTittleDocument(String tittleDocument) {
        this.tittleDocument = tittleDocument;
    }

    public String getDetailDocument() {
        return detailDocument;
    }

    public void setDetailDocument(String detailDocument) {
        this.detailDocument = detailDocument;
    }

    public int getSeekBarNum() {
        return seekBarNum;
    }

    public void setSeekBarNum(int seekBarNum) {
        this.seekBarNum = seekBarNum;
    }
}
