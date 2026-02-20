package com.xworkz.food.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FoodDTO {

    private String food;
    private int rating;
    private String category;
    private double price;
    private String description;
}
