package com.example.project;

public class Locations {
    private String location_name;
    private String price;
    private String imageUrl;

    public Locations(String location_name, String price, String imageUrl) {
        this.location_name = location_name;
        this.price = price;
        this.imageUrl = imageUrl;
    }

    public Locations() {
    }

    public String getLocation_name() {
        return location_name;
    }

    public void setLocation_name(String location_name) {
        this.location_name = location_name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
