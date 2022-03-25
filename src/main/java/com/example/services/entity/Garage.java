package com.example.services.entity;

import com.example.services.enums.StatusType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Garage {
    String uuid;
    Vehicle vehicle;
    StatusType status;


}
