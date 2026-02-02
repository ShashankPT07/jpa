package com.xworkz.employee.external;

import com.xworkz.employee.entity.EmployeeEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class EmployeeCreate {

    public static void main(String[] args) {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("xworkz");
        EntityManager entityManager = factory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();

        EmployeeEntity employee = new EmployeeEntity(101, "Alice", "IT", 75000, 5);
        entityManager.persist(employee);

        transaction.commit();
        entityManager.close();
        factory.close();
    }
}
