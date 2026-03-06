package com.xworkz.bankingSystem.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BankDTO {
    private int id;
    private String name;
    private String accountNumber;
    private String bankName;
    private String phoneNumber;
    private double balance;

}
