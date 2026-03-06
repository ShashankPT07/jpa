package com.xworkz.bankingSystem.repo;

import com.xworkz.bankingSystem.entity.BankEntity;

import java.util.List;

public interface BankDAO {

    boolean save(BankEntity bankEntity);

List<BankEntity> read();

BankEntity getDataBasedOnAccountNumber(String accountNumber);

    BankEntity getDataBasedOnPhoneNumber(String phoneNumber);

    BankEntity getDataBasedOnId(int id);

    void update(BankEntity bankEntity);

    void delete(int id);
}
