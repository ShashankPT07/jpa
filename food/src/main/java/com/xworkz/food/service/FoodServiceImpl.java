package com.xworkz.food.service;

import com.xworkz.food.dao.FoodDAO;
import com.xworkz.food.dto.FoodDTO;
import com.xworkz.food.entity.FoodEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class FoodServiceImpl implements FoodService{

    @Autowired
    FoodDAO foodDAO;

    @Override
    public void saveData(FoodDTO foodDTO) {
        System.out.println("this is service"+foodDTO);
        FoodEntity foodEntity=new FoodEntity();
        foodEntity.setFood(foodDTO.getFood());
        foodEntity.setRating(foodDTO.getRating());
        foodEntity.setCategory(foodDTO.getCategory());
        foodEntity.setPrice(foodDTO.getPrice());
        foodEntity.setDescription(foodDTO.getDescription());
        foodDAO.save(foodEntity);
    }

    @Override
    public List<FoodDTO> getDto() {
        List<FoodEntity> foodEntities = foodDAO.getflightdata();

        if (!foodEntities.isEmpty()) {
            List<FoodDTO> foodDTOS = new ArrayList<>();
            foodEntities.forEach(foodEntity -> {

                FoodDTO foodDTO = new FoodDTO();
                foodDTO.setFood(foodEntity.getFood());
                foodDTO.setRating(foodEntity.getRating());
                foodDTO.setCategory(foodEntity.getCategory());
                foodDTO.setPrice(foodEntity.getPrice());
                foodDTO.setDescription(foodEntity.getDescription());
                foodDTOS.add(foodDTO);

            });
            return foodDTOS;
        } else {
return Collections.emptyList();
        }
    }
}
