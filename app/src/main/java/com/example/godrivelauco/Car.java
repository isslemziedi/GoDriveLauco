/*
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

*/





package com.example.godrivelauco;
import java.io.Serializable;

public class Car implements Serializable {
    private String name;
    private String transmission;
    private double rating;
    private int pricePerDay;
    private String imageResource;
    private boolean isFavorite;
    private Owner owner;

    // Empty constructor for Firebase
    public Car() {}

    public Car(String name, String transmission, double rating, int pricePerDay, String imageResource, Owner owner) {
        this.name = name;
        this.transmission = transmission;
        this.rating = rating;
        this.pricePerDay = pricePerDay;
        this.imageResource = imageResource;
        this.isFavorite = false;
        this.owner = owner;
    }

    // Getters
    public String getName() { return name; }
    public String getTransmission() { return transmission; }
    public double getRating() { return rating; }
    public int getPricePerDay() { return pricePerDay; }
    public String getImageResource() { return imageResource; }
    public boolean isFavorite() { return isFavorite; }
    public Owner getOwner() { return owner; }

    // Setters
    public void setName(String name) { this.name = name; }
    public void setTransmission(String transmission) { this.transmission = transmission; }
    public void setRating(double rating) { this.rating = rating; }
    public void setPricePerDay(int pricePerDay) { this.pricePerDay = pricePerDay; }
    public void setImageResource(String imageResource) { this.imageResource = imageResource; }
    public void setFavorite(boolean favorite) { isFavorite = favorite; }
    public void setOwner(Owner owner) { this.owner = owner; }
}

// Moved Owner class into the same file for consistency
class Owner implements Serializable {
    private String name;
    private String email;
    private String imageUrl;
    private String phoneNumber;

    // Empty constructor for Firebase
    public Owner() {}

    public Owner(String name, String email, String imageUrl, String phoneNumber) {
        this.name = name;
        this.email = email;
        this.imageUrl = imageUrl;
        this.phoneNumber = phoneNumber;
    }

    // Getters
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getImageUrl() { return imageUrl; }
    public String getPhoneNumber() { return phoneNumber; }

    // Setters
    public void setName(String name) { this.name = name; }
    public void setEmail(String email) { this.email = email; }
    public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }
}