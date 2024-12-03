package com.example.godrivelauco;

public class Brand {
    private String name;
    private String logoUrl; // Changé de int à String pour stocker l'URL de l'image

    public Brand() {} // Constructeur vide requis pour Firebase

    public Brand(String name, String logoUrl) {
        this.name = name;
        this.logoUrl = logoUrl;
    }

    public String getName() {
        return name;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }
}
