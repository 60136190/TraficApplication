package com.example.traficapplication.activities.models;

public class Function {
    private int functionAvt;
    private String functionTittle;

    public Function(int funtionAvt, String functionTittle) {
        this.functionAvt = funtionAvt;
        this.functionTittle = functionTittle;
    }

    public int getFuntionAvt() {
        return functionAvt;
    }

    public void setFuntionAvt(int funtionAvt) {
        this.functionAvt = funtionAvt;
    }

    public String getFunctionTittle() {
        return functionTittle;
    }

    public void setFunctionTittle(String functionTittle) {
        this.functionTittle = functionTittle;
    }
}
