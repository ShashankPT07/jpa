package com.xworkz.bookentity.external;



import com.xworkz.bookentity.entity.BookEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class BookCreate {

    public static void main(String[] args) {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("xworkz");
        EntityManager entityManager = factory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();

        BookEntity book = new BookEntity(1, "Effective Java", "Joshua Bloch", 450.0, 416);
        entityManager.persist(book);

        transaction.commit();
        entityManager.close();
        factory.close();
    }
}
