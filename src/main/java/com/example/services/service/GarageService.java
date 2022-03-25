package com.example.services.service;


import com.example.services.entity.Vehicle;
import com.example.services.excepiton.ResourceException;

public  interface GarageService {

    /**
     * POST
     *
     * @param vehicle to search
     * @return the ResponseEntity with status 201 (Created) and string value in body
     * @throws ResourceException if the Location URI syntax is incorrect
     */
    String park(Vehicle vehicle);

    /**
     * GET
     *
     * @param id to search
     * @returnthe ResponseEntity with status 200 (OK) and Remove vehicle mapping
     * @throws Exception
     */
    void leave(String id);

    /**
     * POST
     *
     * @return the ResponseEntity with status 200 (ok) and string value in vehicle mapping
     */
    String status();
}
