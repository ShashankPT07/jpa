package com.xworkz.employee.external;

import com.xworkz.employee.entity.EmployeeEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EmployeeRead {

    public static void main(String[] args) {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("xworkz");
        EntityManager entityManager = factory.createEntityManager();

        EmployeeEntity employee = entityManager.find(EmployeeEntity.class, 101);
        System.out.println(employee);

        entityManager.close();
        factory.close();
    }
}
