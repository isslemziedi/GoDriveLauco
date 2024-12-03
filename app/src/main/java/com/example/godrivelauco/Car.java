package com.example.godrivelauco;

public class Car {
    private String name;
    private String transmission;
    private double rating;
    private int pricePerDay;
    private String imageResource;  // Nom de la ressource drawable
    private boolean isFavorite;

    // Constructeur vide pour Firebase
    public Car() {}

    public Car(String name, String transmission, double rating, int pricePerDay, String imageResource) {
        this.name = name;
        this.transmission = transmission;
        this.rating = rating;
        this.pricePerDay = pricePerDay;
        this.imageResource = imageResource;
        this.isFavorite = false;
    }

    // Getters
    public String getName() { return name; }
    public String getTransmission() { return transmission; }
    public double getRating() { return rating; }
    public int getPricePerDay() { return pricePerDay; }
    public String getImageResource() { return imageResource; }
    public boolean isFavorite() { return isFavorite; }

    // Setters pour Firebase
    public void setName(String name) { this.name = name; }
    public void setTransmission(String transmission) { this.transmission = transmission; }
    public void setRating(double rating) { this.rating = rating; }
    public void setPricePerDay(int pricePerDay) { this.pricePerDay = pricePerDay; }
    public void setImageResource(String imageResource) { this.imageResource = imageResource; }
    public void setFavorite(boolean favorite) { isFavorite = favorite; }
}