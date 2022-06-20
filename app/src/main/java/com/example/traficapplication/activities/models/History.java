package com.example.traficapplication.activities.models;

public class History {
    private String mark;
    private String idUser;

    public History(String mark, String idUser) {
        this.mark = mark;
        this.idUser = idUser;
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
}
