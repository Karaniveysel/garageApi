package com.example.services.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;


import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Vehicle {
        @NotEmpty(message = "Type cannot be empty or null")
        String type;
        @NotEmpty(message = "Color cannot be empty or null")
        String color;
        @NotEmpty(message = "Plate cannot be empty or null")
        String plate;
        int slots;

    }
