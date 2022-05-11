package com.example.traficapplication.activities.models;

public class Trick {
    private String tittleTrick, detailTrick;

    public Trick(String tittleTrick, String detailTrick) {
        this.tittleTrick = tittleTrick;
        this.detailTrick = detailTrick;
    }

    public String getTittleTrick() {
        return tittleTrick;
    }

    public void setTittleTrick(String tittleTrick) {
        this.tittleTrick = tittleTrick;
    }

    public String getDetailTrick() {
        return detailTrick;
    }

    public void setDetailTrick(String detailTrick) {
        this.detailTrick = detailTrick;
    }
}
