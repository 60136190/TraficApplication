package com.example.traficapplication.activities.models;

public class Signal {
    private int signalImg;
    private String signalName,signalDetail;

    public Signal(int signalImg, String signalName, String signalDetail) {
        this.signalImg = signalImg;
        this.signalName = signalName;
        this.signalDetail = signalDetail;
    }

    public int getSignalImg() {
        return signalImg;
    }

    public void setSignalImg(int signalImg) {
        this.signalImg = signalImg;
    }

    public String getSignalName() {
        return signalName;
    }

    public void setSignalName(String signalName) {
        this.signalName = signalName;
    }

    public String getSignalDetail() {
        return signalDetail;
    }

    public void setSignalDetail(String signalDetail) {
        this.signalDetail = signalDetail;
    }
}
