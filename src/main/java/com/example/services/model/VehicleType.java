package com.example.services.model;

public enum VehicleType {

    car(1), jeep(2), truck(4);

    private int width;

    VehicleType(int width) {
        this.width = width;
    }

    public int getWidth() {
        return width;
    }
}
