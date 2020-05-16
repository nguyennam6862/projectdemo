package com.example.sneaker.model;

import java.io.Serializable;

public class Color implements Serializable{
    private String color;

    public Color(String color) {
        this.color = color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }
}
