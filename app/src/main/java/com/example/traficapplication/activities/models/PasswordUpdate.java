package com.example.traficapplication.activities.models;

public class PasswordUpdate {
    String password, newpassword,confirmpassword;

    public PasswordUpdate(String password, String newpassword, String confirmpassword) {
        this.password = password;
        this.newpassword = newpassword;
        this.confirmpassword = confirmpassword;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNewpassword() {
        return newpassword;
    }

    public void setNewpassword(String newpassword) {
        this.newpassword = newpassword;
    }

    public String getConfirmpassword() {
        return confirmpassword;
    }

    public void setConfirmpassword(String confirmpassword) {
        this.confirmpassword = confirmpassword;
    }
}
