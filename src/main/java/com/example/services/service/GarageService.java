package com.example.services.service;


import com.example.services.entity.Garage;
import com.example.services.entity.Vehicle;
import com.example.services.model.GarageDto;

public  interface GarageService {


    String park(Vehicle vehicle);

    void leave(String uuid);

    String status();
}
