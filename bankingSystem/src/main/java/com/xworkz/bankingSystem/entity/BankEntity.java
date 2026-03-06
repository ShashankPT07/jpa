package com.xworkz.bankingSystem.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "bankdetails")
@NamedQuery(name = "readData",query = "select e from BankEntity e")
@NamedQuery(name = "deleteData",query = "delete from BankEntity entity where entity.id=:getId")
@NamedQuery(name = "findByAccountNumber" ,query = "select entity from BankEntity entity where entity.accountNumber=:getAccountNumber")
@NamedQuery(name = "findByPhoneNumber" ,query = "select entity from BankEntity entity where entity.phoneNumber=:getPhoneNumber")
public class BankEntity {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String accountNumber;
    private String bankName;
    private String phoneNumber;
    private double balance;
}
