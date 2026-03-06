package com.xworkz.bankingSystem.controller;


import com.xworkz.bankingSystem.dto.BankDTO;
import com.xworkz.bankingSystem.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/")
public class BankController {

    @Autowired
    BankService bankService;

    public BankController() {
        System.out.println("this is controller class");
    }
    @PostMapping("/saveData")
    public String bankDetails(Model model, BankDTO bankDTO){

        String message=bankService.saveData(bankDTO);
        if(message.equalsIgnoreCase("Registered successfully")) {
            model.addAttribute("success",message);
            return "index";
        }else if (message.equalsIgnoreCase("Not Registered")){
            model.addAttribute("errmsg",message);
            return "index";
        }else{
            model.addAttribute("errmsg",message);
            return "index";
        }
    }
    @GetMapping("/read")
    public String readDetails(Model model){
        List<BankDTO> bankDTOS=bankService.readData();
        model.addAttribute("readDetails",bankDTOS);
        return "read";
    }

    @GetMapping("/update")
    private String updateDetails(@RequestParam int id,Model model){
        System.out.println("id------------"+id);
        BankDTO bankDTO=bankService.getDataInServiceBadesOnId(id);
        if (bankDTO!=null){
            model.addAttribute("dto",bankDTO);
            return "update";
        }
        return "index";
    }

    @PostMapping("update")
    public String update(BankDTO bankDTO,Model model){
        bankService.updateInService(bankDTO);
List<BankDTO> dtos=bankService.readData();
model.addAttribute("readDetails",dtos);
return "read";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam int id,Model model){

        bankService.deleteInService(id);
        List<BankDTO> dtos=bankService.readData();
        model.addAttribute("readDetails",dtos);
        return "read";
    }
}
