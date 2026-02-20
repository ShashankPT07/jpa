package com.xworkz.food.dao;

import com.xworkz.food.entity.FoodEntity;

import java.util.List;

public interface FoodDAO {
    void save(FoodEntity foodEntity);

    List<FoodEntity> getflightdata();
}
