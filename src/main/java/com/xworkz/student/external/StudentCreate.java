package com.xworkz.student.external;

import com.xworkz.student.entity.StudentDetailsEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class StudentCreate {

    public static void main(String[] args) {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("xworkz");
        EntityManager entityManager = factory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();

        StudentDetailsEntity student = new StudentDetailsEntity(1, "Rahul", 22, "Java", 25000);
        entityManager.persist(student);

        transaction.commit();
        entityManager.close();
        factory.close();
    }
}
