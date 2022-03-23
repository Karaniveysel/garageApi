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
public class Vehicle extends Garage{
        @NotEmpty(message = "type bos birakilamaz.")
        String type;
        @NotEmpty(message = "color bos birakilamaz.")
        String color;
        @NotEmpty(message = "plate bos birakilamaz.")
        String plate;
        int slots;

    }
