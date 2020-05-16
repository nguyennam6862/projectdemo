package com.example.sneaker.model;

import java.io.Serializable;

import java.util.List;

public class Shoes implements Serializable{
    private String name;

    private String avatar;

    private List<String> images;

    private List<String> colors;

    private List<String> categories;

    private Long price;

    private List<Size> sizes;

    public Shoes(){

    }

    public Shoes(String name, String avatar, List<String> images, List<String> colors, List<String> categories, Long price, List<Size> sizes) {
        this.name = name;
        this.avatar = avatar;
        this.images = images;
        this.colors = colors;
        this.categories = categories;
        this.price = price;
        this.sizes = sizes;
    }

    public List<Size> getSizes() {
        return sizes;
    }

    public void setSizes(List<Size> sizes) {
        this.sizes = sizes;
    }

    public String getName() {
        return name;
    }

    public String getAvatar() {
        return avatar;
    }

    public List<String> getImages() {
        return images;
    }

    public List<String> getColors() {
        return colors;
    }

    public List<String> getCategories() {
        return categories;
    }

    public Long getPrice() {
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    public void setColors(List<String> colors) {
        this.colors = colors;
    }

    public void setCategories(List<String> categories) {
        this.categories = categories;
    }

    public void setPrice(Long price) {
        this.price = price;
    }


}
