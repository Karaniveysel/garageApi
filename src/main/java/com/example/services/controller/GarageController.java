package com.example.services.controller;

import com.example.services.entity.Vehicle;
import com.example.services.enums.VehicleType;
import com.example.services.excepiton.ResourceException;
import com.example.services.service.GarageService;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Arrays;

@RestController
@RequestMapping("/garage")

public class GarageController {
    private static final Logger log = LogManager.getLogger(GarageController.class);

    @Autowired
    public GarageService garageService;

    /**
     * POST
     *
     * @param vehicle to add
     * @return the ResponseEntity with status 201 (Created) and string value in body
     * @throws ResourceException if the Location URI syntax is incorrect
     */
    @PostMapping("/park")
    public ResponseEntity<String> park(@Valid @RequestBody Vehicle vehicle){
        log.debug("REST request to get getType : {}", vehicle.getType());
        if(Arrays.stream(VehicleType.values()).filter(x->x.name().equals(vehicle.getType())).count()==0)
            throw new ResourceException(HttpStatus.BAD_REQUEST,new Exception("Please, enter the type correctly"));

        return new ResponseEntity<>(garageService.park(vehicle), HttpStatus.CREATED);

    }

    /**
     * GET
     *
     * @param id to search
     * @returnthe ResponseEntity with status 200 (OK) and Remove vehicle mapping
     * @throws Exception
     */
    @GetMapping ("/leave/{id}")
    public ResponseEntity leave(@PathVariable String id){
        log.debug("REST request to get getId : {}", id);
        if(StringUtils.isEmpty(id))
            throw new ResourceException(HttpStatus.BAD_REQUEST,new Exception("Id value  null or  Empty"));
        garageService.leave(id);
        log.info("Remove Success...");
        return new ResponseEntity(HttpStatus.OK);

    }

    /**
     * POST
     *
     * @return the ResponseEntity with status 200 (ok) and string value in vehicle mapping
     */
    @PostMapping("/status")
    public ResponseEntity status(){
        log.info("REST request to Garage Status Check...");
        return new ResponseEntity<>(garageService.status(), HttpStatus.OK);

    }




}
