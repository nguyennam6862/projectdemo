package com.example.sneaker.model;

import java.io.Serializable;

public class Size implements Serializable{
    private double size;

    public Size(double size) {
        this.size = size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public double getSize() {
        return size;
    }
}
