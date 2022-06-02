package com.example.traficapplication.activities.models;

public class UserRegister {
    String email;
    String password;
    String fullName;
    String phoneNumber;
    String address;

    public UserRegister(String email, String password, String fullName, String phoneNumber, String address) {
        this.email = email;
        this.password = password;
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
