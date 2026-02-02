package com.xworkz.employee.external;

import com.xworkz.employee.entity.EmployeeEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class EmployeeDelete {

    public static void main(String[] args) {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("xworkz");
        EntityManager entityManager = factory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();

        EmployeeEntity employee = entityManager.find(EmployeeEntity.class, 101);
        entityManager.remove(employee);

        transaction.commit();
        entityManager.close();
        factory.close();
    }
}
