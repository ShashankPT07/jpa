package com.xworkz.food.service;

import com.xworkz.food.dto.FoodDTO;

import java.util.List;

public interface FoodService {
    void saveData(FoodDTO foodDTO);


    List<FoodDTO> getDto();
}
