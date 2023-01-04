package com.bootcamp;

public class Vehicle {

    private String brand, model;
    private int price;

    public Vehicle() {}

    public Vehicle(String marca, String modelo, int costo) {
        this.brand = marca;
        this.model = modelo;
        this.price = costo;
    }

    public String getBrand() { return brand; }

    public void setBrand(String brand) { this.brand = brand; }

    public String getModel() { return model; }

    public void setModel(String model) { this.model = model; }

    public int getPrice() { return price; }

    public void setPrice(int price) { this.price = price; }

    @Override
    public String toString() { return String.format("%-10s | %-10s | $ %d ", brand, model, price); }
}
