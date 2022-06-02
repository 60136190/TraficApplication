package com.example.traficapplication.activities.models;

public class LoginResponse {
    private int status;
    private String msg;
    private String id;

    public LoginResponse(int status, String msg, String id) {
        this.status = status;
        this.msg = msg;
        this.id = id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
