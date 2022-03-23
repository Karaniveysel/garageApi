package com.example.services.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Garage {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long garageId;
    Vehicle vehicle;
    String status;


}
