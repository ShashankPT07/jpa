package com.xworkz.bankingSystem.service;

import com.xworkz.bankingSystem.dto.BankDTO;
import com.xworkz.bankingSystem.entity.BankEntity;
import com.xworkz.bankingSystem.repo.BankDAO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class BankServiceImpl implements BankService {

    @Autowired
    BankDAO bankDAO;

    @Override
    public String saveData(BankDTO bankDTO) {

        BankDTO accDto = getDataInServiceBasedOnAccountNumber(bankDTO.getAccountNumber());
        if (accDto != null) {
            return "AccountNumber already exists";
        }
        BankDTO phDto = getDataInServiceBasedOnPhoneNumber(bankDTO.getPhoneNumber());
        if (phDto != null) {
            return "PhoneNumber already exists";
        }

        BankEntity bankEntity = new BankEntity();
        BeanUtils.copyProperties(bankDTO, bankEntity);
        if (bankDAO.save(bankEntity)) {
            return "Registered successfully";
        }

        return "Not Registered";
    }


    @Override
    public List<BankDTO> readData() {

        List<BankEntity> entities=bankDAO.read();
        if (entities!=null){
            List<BankDTO> dtos=new ArrayList<>();
            for (BankEntity entity :entities){
                BankDTO dto=new BankDTO();
                BeanUtils.copyProperties(entity,dto);
               dtos.add(dto);
            }
            return dtos;
        }

        return Collections.emptyList();
    }

    @Override
    public BankDTO getDataInServiceBasedOnAccountNumber(String getAccountNumber) {

BankEntity entity=bankDAO.getDataBasedOnAccountNumber(getAccountNumber);

if (entity!=null){
    BankDTO dto=new BankDTO();
    BeanUtils.copyProperties(entity,dto);
    return dto;
}
        return null;
    }

    @Override
    public BankDTO getDataInServiceBasedOnPhoneNumber(String getPhoneNumber) {
        BankEntity entity=bankDAO.getDataBasedOnPhoneNumber(getPhoneNumber);
        if (entity!=null){
            BankDTO dto=new BankDTO();
            BeanUtils.copyProperties(entity,dto);
            return dto;
        }
        return null;
    }

    @Override
    public BankDTO getDataInServiceBadesOnId(int getId) {

        BankEntity bankEntity=bankDAO.getDataBasedOnId(getId);
if (bankEntity!=null){
    BankDTO dto=new BankDTO();
    BeanUtils.copyProperties(bankEntity,dto);
    return dto;
}
        return null;
    }

    @Override
    public void updateInService(BankDTO bankDTO) {
        if(bankDTO.getName()==null || bankDTO.getName().length()<3){
            throw new RuntimeException("Invalid name");
        }

        if(bankDTO.getAccountNumber()==null || bankDTO.getAccountNumber().length()<9){
            throw new RuntimeException("Invalid account number");
        }

        if(bankDTO.getPhoneNumber()==null || bankDTO.getPhoneNumber().length()!=10){
            throw new RuntimeException("Invalid phone number");
        }

        if(bankDTO.getBalance()<=0){
            throw new RuntimeException("Balance must be greater than 0");
        }

        BankEntity bankEntity=new BankEntity();
        BeanUtils.copyProperties(bankDTO,bankEntity);
        bankDAO.update(bankEntity);
    }

    @Override
    public void deleteInService(int getId) {
        BankEntity bankEntity=bankDAO.getDataBasedOnId(getId);
        if (bankEntity!=null){
            bankDAO.delete(getId);
        }

    }


}
