package com.example.shaikhbro.classsavingtest.pojo;

/**
 * Created by ShaikhBro on 5/15/2017.
 */
public class MyPOJO {
    private int number;
    private float decimal;
    private String text;

    public MyPOJO() {
    }

    public MyPOJO(int number, float decimal, String text) {
        this.number = number;
        this.decimal = decimal;
        this.text = text;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public float getDecimal() {
        return decimal;
    }

    public void setDecimal(float decimal) {
        this.decimal = decimal;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
