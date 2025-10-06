package com.example.appdelicia01.domain.model;

public class Product {
    private String id;          // identificador único
    private String name;        // nombre
    private String description; // descripción
    private double price;       // precio
    private int imageResId;     // imagen local (drawable)

    public Product(String id, String name, String description, double price, int imageResId) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.imageResId = imageResId;
    }

    // Getters
    public String getId() { return id; }
    public String getName() { return name; }
    public String getDescription() { return description; }
    public double getPrice() { return price; }
    public int getImageResId() { return imageResId; }
}
