package com.xworkz.flight.controller;

import com.xworkz.flight.dto.FlightDTO;
import com.xworkz.flight.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class FlightController {

    @Autowired
    private FlightService flightService;

    @PostMapping("/fly")
    public String flightRegister(FlightDTO flightDTO, Model model) {

        System.out.println("Controller === " + flightDTO);

        boolean saved = flightService.saveData(flightDTO);

        if (saved) {
            model.addAttribute("dto", flightDTO);
            model.addAttribute("success", "Flight details submitted successfully...!");
            return "index";
        } else {
            model.addAttribute("invalid", "Please enter valid flight details...!");
            return "index";
        }
    }
}
