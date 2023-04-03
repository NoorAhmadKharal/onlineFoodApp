package com.example.onlinefoodapplicationproject;

public class Food {

    // Create Two Data Type
    private String tittle;
    private int image;

    // Constructor
    public Food(String tittle, int image) {
        this.tittle = tittle;
        this.image = image;
    }

    // Set getter and setter
    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
