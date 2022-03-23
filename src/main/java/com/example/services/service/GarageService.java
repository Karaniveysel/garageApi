package com.example.services.service;


import com.example.services.entity.Garage;
import com.example.services.entity.Vehicle;
import com.example.services.model.GarageDto;

public  interface GarageService {


    Garage park(Vehicle vehicle);

    Garage leave(Garage dto);

    String status();
}
