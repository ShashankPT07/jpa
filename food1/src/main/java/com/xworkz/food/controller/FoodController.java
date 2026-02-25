package com.xworkz.food.controller;

import com.xworkz.food.dto.FoodDTO;
import com.xworkz.food.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/")

public class FoodController {

    @Autowired
     private FoodService foodService;


    @PostMapping("/foo")
    public ModelAndView food(FoodDTO  foodDTO,Model model){
        foodService.saveData(foodDTO);
       ModelAndView modelAndView=new ModelAndView();
       modelAndView.addObject("dto",foodDTO);
       modelAndView.setViewName("register successfully");
       return modelAndView;
    }
    @GetMapping("readAllData")
    public String getData(Model model){

        List<FoodDTO> dtos=foodService.getDto();
      model.addAttribute("dtos",dtos);
        System.out.println("read data"+dtos);
        return "submit";

    }
}
