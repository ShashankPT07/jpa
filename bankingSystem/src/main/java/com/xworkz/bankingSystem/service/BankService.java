package com.xworkz.bankingSystem.service;

import com.xworkz.bankingSystem.dto.BankDTO;

import java.util.List;

public interface BankService {

  String saveData(BankDTO bankDTO);

    List<BankDTO> readData();

    BankDTO getDataInServiceBasedOnAccountNumber(String getAccountNumber);

    BankDTO getDataInServiceBasedOnPhoneNumber(String getPhoneNumber);

    BankDTO getDataInServiceBadesOnId(int getId);

    void updateInService(BankDTO bankDTO);

    void  deleteInService(int getId);
}
