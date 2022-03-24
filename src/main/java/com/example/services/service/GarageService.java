package com.example.services.service;


import com.example.services.entity.Vehicle;

public  interface GarageService {


    String park(Vehicle vehicle);

    void leave(String uuid);

    String status();
}
