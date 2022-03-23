package com.example.services.controller;

import com.example.services.entity.Garage;
import com.example.services.entity.Vehicle;
import com.example.services.service.GarageService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/garages")

public class GarageController {
    private static final Logger log = LogManager.getLogger(GarageController.class);

    @Autowired
    public GarageService garageService;

    @PostMapping("/include/park")
    public ResponseEntity<Garage> includePark(@Valid @RequestBody Vehicle vehicle){
        log.debug("REST request to get getType : {}", vehicle.getType());
        //return garageService.includePark(garage);
        return ResponseEntity.ok().body(garageService.park(vehicle));
    }


    @PostMapping("/leave")
    public Garage leave(@RequestBody Garage garage){
        log.debug("REST request to get getId : {}", garage.getGarageId());
        return garageService.leave(garage);
    }


    @PostMapping("/status")
    public String status(){
        log.info("Garage Durum Kontrolü");
        return garageService.status();
    }




}
