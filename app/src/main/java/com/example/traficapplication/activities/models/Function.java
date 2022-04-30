package com.example.traficapplication.activities.models;

public class Function {
    private int funtionAvt;
    private String functionTittle;

    public Function(int funtionAvt, String functionTittle) {
        this.funtionAvt = funtionAvt;
        this.functionTittle = functionTittle;
    }

    public int getFuntionAvt() {
        return funtionAvt;
    }

    public void setFuntionAvt(int funtionAvt) {
        this.funtionAvt = funtionAvt;
    }

    public String getFunctionTittle() {
        return functionTittle;
    }

    public void setFunctionTittle(String functionTittle) {
        this.functionTittle = functionTittle;
    }
}
