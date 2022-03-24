package com.example.services.controller;

import com.example.services.entity.Garage;
import com.example.services.entity.Vehicle;
import com.example.services.service.GarageService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/garage")

public class GarageController {
    private static final Logger log = LogManager.getLogger(GarageController.class);

    @Autowired
    public GarageService garageService;

    @PostMapping("/park")
    public ResponseEntity<String> park(@Valid @RequestBody Vehicle vehicle){
        log.debug("REST request to get getType : {}", vehicle.getType());
            return new ResponseEntity<>(garageService.park(vehicle), HttpStatus.CREATED);

    }

    @GetMapping ("/leave/{uuid}")
    public ResponseEntity leave(@PathVariable String uuid){
        log.debug("REST request to get getId : {}", uuid);
        garageService.leave(uuid);
        return new ResponseEntity(HttpStatus.OK);

    }


    @PostMapping("/status")
    public ResponseEntity status(){
        log.info("REST request to Garage Status Check...");
        return new ResponseEntity<>(garageService.status(), HttpStatus.OK);

    }




}
